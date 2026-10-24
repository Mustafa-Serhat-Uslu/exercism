import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Etl {
    Map<String, Integer> transform(Map<Integer, List<String>> old) {

        Map<String, Integer> newPoints = new HashMap();

        for(Integer key : old.keySet()){
            List<String> letters = old.get(key); 

                for(String s : letters){
                    newPoints.put(s.toLowerCase(),key);
                }
            
        }

        return newPoints;
        
    }
}
