import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards = new ArrayList<>();
    private int size;

    public Deck(ArrayList<SUIT> suits, ArrayList<RANK> ranks) {
        for (SUIT suit : suits) {
            for (RANK rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
        this.size = cards.size();
    }

    public Card deal() {
        if (!(this.isEmpty())) {
            this.size -= 1;
            return cards.get(size);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (this.cards.size() <= 0);
    }

    public int size() {
        return this.size;
    }

    public void perfectShuffle() {
        ArrayList<Card> shuffled = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < 26; i++) {
            shuffled.add(k, this.cards.get(i));
            k += 2;
        }
        k = 1;
        for (int i = 26; i < 52; i++) {
            shuffled.add(k, this.cards.get(i));
        }
        this.cards = shuffled;
    }

    public int rand(int min, int max) {
       int range = max-min+1;
       return (int)(Math.floor((Math.random() * range) + min));
    }

    public void selectionShuffle() {
        for (int i=0; i<this.size; i++) {
            int card = rand(i, this.size);
            Collections.swap(cards, i, card);
        }
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
