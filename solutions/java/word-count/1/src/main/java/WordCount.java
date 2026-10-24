import java.util.HashMap;
import java.util.Map;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String word : input.toLowerCase().split("[^a-z0-9']+")) {
            word = word.replaceAll("^'+|'+$", "");
            if (!word.isEmpty()) counts.merge(word, 1, Integer::sum);
        }
        return counts;
    }
}