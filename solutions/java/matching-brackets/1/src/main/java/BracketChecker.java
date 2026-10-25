import java.util.*;

class BracketChecker {

    String cleaned;

    List<Character> toPush = List.of('[', '{', '(');
    List<Character> toPop = List.of(']', '}', ')');

    
    BracketChecker(String expression) {
        cleaned = expression.replaceAll("[^\\[\\](){}]", "");
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : cleaned.toCharArray()){
            if(toPush.contains(c)){
                stack.push(c);
            } else{
                Character nextToPop = stack.peek();

                if(nextToPop == null || toPush.indexOf(nextToPop) != toPop.indexOf(c)){
                  return false;
                }

                
                stack.pop();
            }
        }

        return stack.isEmpty(); 
    }

}