import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Card jack = new Card(SUIT.HEARTS, RANK.JACK);
        Card queen = new Card(SUIT.DIAMONDS, RANK.QUEEN);
        Card queen2 = new Card(SUIT.DIAMONDS, RANK.QUEEN);
        ArrayList<SUIT> suits = new ArrayList<>(Arrays.asList(SUIT.HEARTS, SUIT.DIAMONDS));
        ArrayList<RANK> ranks = new ArrayList<>(Arrays.asList(RANK.QUEEN, RANK.TEN));
        Deck deck = new Deck(suits, ranks);
    }
}