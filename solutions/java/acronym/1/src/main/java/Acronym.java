import java.util.Arrays;
import java.util.stream.Collectors;


class Acronym {

    String val = new String();
    
    Acronym(String phrase) {
        val = phrase;

        
        
    }

    String get() {
        String[] words = val.split("[- _]+");

        return Arrays.stream(words)
            .map(s -> s.substring(0, 1))
            .collect(Collectors.joining())
            .toUpperCase();
        
    }

}
