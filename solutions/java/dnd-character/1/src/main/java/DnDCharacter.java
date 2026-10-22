
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {

    private final Random random = new Random();

    private final int strength = ability(rollDice());
    private final int dexterity = ability(rollDice());
    private final int constitution = ability(rollDice());
    private final int intelligence = ability(rollDice());
    private final int wisdom = ability(rollDice());
    private final int charisma = ability(rollDice());

    int ability(List<Integer> scores) {
        return scores.stream()
                .sorted()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    List<Integer> rollDice() {
        return IntStream.range(0, 4)
                .map(i -> random.nextInt(6) + 1)
                .boxed()
                .toList();
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(constitution);
    }
}
