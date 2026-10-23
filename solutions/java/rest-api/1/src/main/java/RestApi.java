
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

class RestApi {

    private final Map<String, Account> users = new TreeMap<>();

    // 1. INITIALIZATION
    RestApi(User... initialUsers) {
        for (User user : initialUsers) {
            users.put(user.name(), new Account(user));
        }
    }

    // 2. ROUTING
    String get(String url) {
        return get(url, null);
    }

    String get(String url, JSONObject payload) {
        if (url.equals("/users")) {
            return getUsers(payload);
        }

        throw new IllegalArgumentException("Unknown URL");
    }

    String post(String url, JSONObject payload) {
        return switch (url) {
            case "/add" -> addUser(payload);
            case "/iou" -> createIou(payload);
            default -> throw new IllegalArgumentException("Unknown URL");
        };
    }

    // 3. REQUEST HANDLERS
    private String getUsers(JSONObject payload) {

        if (payload == null || !payload.has("users")) {
            return usersResponse(users.values());
        }

        JSONArray names = payload.getJSONArray("users");
        List<Account> selected = new ArrayList<>();

        for (int i = 0; i < names.length(); i++) {
            Account user = users.get(names.getString(i));

            if (user != null) {
                selected.add(user);
            }
        }

        return usersResponse(selected);
    }

    private String addUser(JSONObject payload) {
        String name = payload.getString("user");

        Account user = new Account(name);
        users.put(name, user);

        return user.toJson().toString();
    }

    private String createIou(JSONObject payload) {
        Account lender = findUser(payload.getString("lender"));
        Account borrower = findUser(payload.getString("borrower"));
        double amount = payload.getDouble("amount");

        updateDebt(lender, borrower, amount);

        return usersResponse(List.of(lender, borrower));
    }

    private Account findUser(String name) {
        Account user = users.get(name);

        if (user == null) {
            throw new IllegalArgumentException("User not found: " + name);
        }

        return user;
    }

    // 4. BUSINESS LOGIC
    private void updateDebt(Account lender, Account borrower, double amount) {

        // Existing debt in each direction
        double borrowerOwes = borrower.owes.getOrDefault(lender.name, 0.0);
        double lenderOwes = lender.owes.getOrDefault(borrower.name, 0.0);

        // Offset opposite debts and add the new loan
        double remaining = borrowerOwes - lenderOwes + amount;

        clearExistingDebt(lender, borrower);

        if (remaining > 0) {
            borrower.owes.put(lender.name, remaining);
            lender.owedBy.put(borrower.name, remaining);

        } else if (remaining < 0) {
            lender.owes.put(borrower.name, -remaining);
            borrower.owedBy.put(lender.name, -remaining);
        }
    }

    private void clearExistingDebt(Account lender, Account borrower) {
        lender.owes.remove(borrower.name);
        lender.owedBy.remove(borrower.name);

        borrower.owes.remove(lender.name);
        borrower.owedBy.remove(lender.name);
    }

    // 5. RESPONSE FORMATTING
    private String usersResponse(Collection<Account> accounts) {
        List<Account> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing(user -> user.name));

        JSONArray result = new JSONArray();

        for (Account account : sorted) {
            result.put(account.toJson());
        }

        return new JSONObject()
                .put("users", result)
                .toString();
    }

    // 6. INTERNAL DATA MODEL
    private static class Account {

        final String name;
        final Map<String, Double> owes = new HashMap<>();
        final Map<String, Double> owedBy = new HashMap<>();

        Account(String name) {
            this.name = name;
        }

        Account(User user) {
            this(user.name());

            for (Iou iou : user.owes()) {
                owes.put(iou.name, iou.amount);
            }

            for (Iou iou : user.owedBy()) {
                owedBy.put(iou.name, iou.amount);
            }
        }

        JSONObject toJson() {
            return new JSONObject()
                    .put("name", name)
                    .put("owes", new JSONObject(owes))
                    .put("owedBy", new JSONObject(owedBy)) 
                    .put("balance", calculateBalance());
        }

        private double calculateBalance() {
            double balance = 0;

            for (double amount : owedBy.values()) {
                balance += amount;
            }

            for (double amount : owes.values()) {
                balance -= amount;
            }

            return balance;
        }
    }
}
