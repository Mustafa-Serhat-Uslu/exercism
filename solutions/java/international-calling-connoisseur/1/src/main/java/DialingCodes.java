import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    Map<Integer, String> theCodes = new HashMap<>();

    
    public Map<Integer, String> getCodes() {
        return theCodes;
    }

    public void setDialingCode(Integer code, String country) {
        theCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return theCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (theCodes.containsKey(code)) return;
                if (theCodes.values().contains(country)) return;


        theCodes.put(code, country);
    }

    public Integer findDialingCode(String country) {
         for(Map.Entry<Integer, String> entry : theCodes.entrySet()){
             if(country.equals(entry.getValue())){
                 return entry.getKey();
             }
         }
        return null;
     }

    public void updateCountryDialingCode(Integer code, String country) {

        if (!theCodes.values().contains(country)) return;

        Integer dup = findDialingCode(country);
        theCodes.remove(dup);
        this.setDialingCode(code, country);
    }
}
