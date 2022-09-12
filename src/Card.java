public class Card {

    RANK rank;
    SUIT suit;
    int point;

    public Card(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
        switch (rank) {
            case ACE -> this.point = 1;
            case TWO -> this.point = 2;
            case THREE -> this.point = 3;
            case FOUR -> this.point = 4;
            case FIVE -> this.point = 5;
            case SIX -> this.point = 6;
            case SEVEN -> this.point = 7;
            case EIGHT -> this.point = 8;
            case NINE -> this.point = 9;
            case TEN -> this.point = 10;
            case JACK -> this.point = 11;
            case QUEEN -> this.point = 12;
            case KING -> this.point = 13;
        }
    }

    public SUIT getSuit() {
        return this.suit;
    }

    public RANK getRank() {
        return this.rank;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Card)) {
            return false;
        }
        Card card1 = (Card)o;
        return ((card1.getPoint() == this.point) && (card1.getRank() == this.rank) && (card1.getSuit() == this.suit));
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit + "(point value = " + this.point + ")";
    }
}
