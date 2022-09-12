import java.util.ArrayList;

public class Deck {

    public ArrayList<Card> cards = new ArrayList<>();
    public ArrayList<SUIT> suits;
    public ArrayList<RANK> ranks;
    public int size;

    public Deck(ArrayList<SUIT> suits, ArrayList<RANK> ranks) {
        this.suits = suits;
        this.ranks = ranks;
       for (SUIT suit : suits) {
           for (RANK rank : ranks) {
              cards.add(new Card(suit, rank));
           }
       }
       this.size = cards.size();
    }

    public boolean isEmpty() {
        return !(this.cards.size() > 0);
    }

    public int size() {
        return this.cards.size();
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
