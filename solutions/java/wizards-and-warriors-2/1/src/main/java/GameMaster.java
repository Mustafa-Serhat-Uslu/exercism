public class GameMaster {

    // TODO: define a 'describe' method that returns a description of a Character
    public String describe(Character c){
        return "You're a level %d %s with %d hit points.".formatted(c.getLevel(), c.getCharacterClass(), c.getHitPoints());
    }

    // TODO: define a 'describe' method that returns a description of a Destination

    public String describe(Destination d){
        return "You've arrived at %s, which has %d inhabitants.".formatted(d.getName(), d.getInhabitants());
    }

    // TODO: define a 'describe' method that returns a description of a TravelMethod
    public String describe(TravelMethod tm){

        String filler = tm.toString() == "WALKING" ? "by walking" : "on horseback";
        
        return "You're traveling to your destination %s.".formatted(filler);
    }
    
    
    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod


    public String describe(Character c, Destination d, TravelMethod tm){


        return describe(c) + " " + describe(tm) + " " + describe(d);
    }
    

    // TODO: define a 'describe' method that returns a description of a Character and Destination

    
    public String describe(Character c, Destination d){


        return describe(c) + " " + describe(TravelMethod.WALKING) + " " + describe(d);
    }
}
