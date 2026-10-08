class Fighter {
    
    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }

}

// TODO: define the Warrior class

class Warrior extends Fighter{

    String name = "Warrior";
    
    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;   
    }

    @Override
public String toString() {
    return "Fighter is a %s".formatted(getClass().getSimpleName());
}
}

// TODO: define the Wizard class

class Wizard extends Fighter{

    String name = "Wizard";
    
    boolean hasSpellPrepped = false;
    
    @Override
    boolean isVulnerable() {
        return hasSpellPrepped ? false : true;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return hasSpellPrepped ? 12 : 3;   
    }

    void prepareSpell() {
        hasSpellPrepped = true;
    }

    @Override
public String toString() {
    return "Fighter is a %s".formatted(getClass().getSimpleName());
}
    
}
