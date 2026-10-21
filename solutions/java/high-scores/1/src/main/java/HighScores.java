import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HighScores {

    List<Integer> sorted;
    List<Integer> scores;

    
    public HighScores(List<Integer> highScores) {
        scores = highScores;
        sorted = new ArrayList<Integer>(scores);
        sorted.sort(Collections.reverseOrder());
    }

    List<Integer> scores() {
        return scores;
    }

    Integer latest() {
        return scores.get(scores.size() - 1);
    }

    Integer personalBest() {
        return sorted.get(0);
    }

    List<Integer> personalTopThree() {
        return sorted.subList(0, Math.min(3, sorted.size()));
    }

}
