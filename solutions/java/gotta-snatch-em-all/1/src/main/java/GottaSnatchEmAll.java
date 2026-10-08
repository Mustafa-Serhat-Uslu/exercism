import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {

        if(myCollection.size() == 0 || theirCollection.size() == 0) return false;
        
        return !myCollection.containsAll(theirCollection) && !theirCollection.containsAll(myCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
            Set<String> common = new HashSet<>(collections.get(0));

            for (Set<String> col : collections){
                common.retainAll(col);
            }

            return common;
     }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> allCards = new HashSet<>();

        for(Set<String> col : collections){
            allCards.addAll(col);
        }

        return allCards;    
    }
}
