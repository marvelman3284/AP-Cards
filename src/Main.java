import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        blackjack();
    }

    public static void blackjack() {
        boolean playing = true;

        ArrayList<Card> playerCards = new ArrayList<>();
        ArrayList<Card> dealerCards = new ArrayList<>();
        ArrayList<SUIT> suits = new ArrayList<>(Arrays.asList(SUIT.HEARTS, SUIT.CLUBS, SUIT.SPADES, SUIT.DIAMONDS));
        ArrayList<RANK> ranks = new ArrayList<>(Arrays.asList(RANK.values()));

        Deck deck = new Deck(suits, ranks);

        deck.shuffle();

        playerCards.add(deck.deal());
        dealerCards.add(deck.deal());
        playerCards.add(deck.deal());
        dealerCards.add(deck.deal());

        System.out.println("You are dealt a " + playerCards.get(0).toString());
        System.out.println("The dealer has a " + dealerCards.get(0).toString());
        System.out.println("You are dealt a " + playerCards.get(1).toString());
        System.out.println("The dealer is dealt a face down card");
        System.out.println("Your total is " + getTotal(playerCards) + "\n");


        int playerTotal = getTotal(playerCards);
        if (playerTotal > 20) {
            System.out.println("You busted and lost!");
            playing = false;
        }

        if ((playerCards.get(0).point == 11 || playerCards.get(1).point == 11) && (playerCards.get(0).point == 10 || playerCards.get(1).point == 10)) {
               System.out.println("You got blackjack!");
               playing = false;
        }
        /*
        TODO:
        splitting
        gambling
        insurance
        aces
        doubling down
         */

        while(playing) {
            System.out.println("Would you like to hit or stand? (h/s): ");
            char choice = sc.nextLine().charAt(0);
            if (choice == 'h') {
                playerCards.add(deck.deal());
                System.out.println("You are dealt a " + playerCards.get(playerCards.size()-1).toString());
                System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                playerTotal = getTotal(playerCards);

                if (playerTotal > 21) {
                    System.out.println("You busted and lost! (total: " + playerTotal + ")");
                    playing = false;
                }
            } else if (choice == 's') {
                System.out.println("The dealers other card was a " + dealerCards.get(1).toString());
                while (true) {
                    if (getTotal(dealerCards) < 17) {
                        dealerCards.add(deck.deal());
                        System.out.println("The dealer is dealt a " + dealerCards.get(dealerCards.size() - 1).toString());
                        System.out.println("Dealers new total: " + getTotal(dealerCards) + "\n");
                    } else if (getTotal(dealerCards) > 21) {
                        System.out.println("The dealer busted and you won!");
                        playing = false;
                        break;
                    } else if (getTotal(dealerCards) >= 17) {
                        int dealerTotal = getTotal(dealerCards);

                        System.out.println("The dealers total is " + dealerTotal);
                        System.out.println("Your total is: " + playerTotal);
                        if (dealerTotal > playerTotal) {
                            System.out.println("You lose!");
                        } else {
                            System.out.println("You win!");
                        }
                        playing = false;
                        break;
                    }
                }
            }
        }
    }

    public static int getTotal(ArrayList<Card> cards) {
        int total = 0;
        for (Card card : cards) {
            total += card.point;
        }
        return total;
    }
}