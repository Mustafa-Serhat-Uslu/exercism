import java.util.List;

class ResistorColorTrio {

    private static final List<String> COLORS = List.of(
        "black", "brown", "red", "orange", "yellow",
        "green", "blue", "violet", "grey", "white"
    );

    String label(String[] colors) {
        int first = COLORS.indexOf(colors[0]);
        int second = COLORS.indexOf(colors[1]);
        int multiplier = COLORS.indexOf(colors[2]);

        long value = (first * 10L + second);

        for (int i = 0; i < multiplier; i++) {
            value *= 10;
        }

        if (value >= 1_000_000_000L)
            return value / 1_000_000_000L + " gigaohms";

        if (value >= 1_000_000L)
            return value / 1_000_000L + " megaohms";

        if (value >= 1_000L)
            return value / 1_000L + " kiloohms";

        return value + " ohms";
    }
}