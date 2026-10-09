import java.util.Arrays;

class ResistorColor {

    String[] arr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    
    
    int colorCode(String color) {
        return Arrays.asList(arr).indexOf(color);
    }

    String[] colors() {
        return arr;
    }
}
