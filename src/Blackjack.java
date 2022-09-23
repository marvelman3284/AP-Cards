import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Blackjack {

    public static Scanner sc = new Scanner(System.in);

    public static void main(Player player) {
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

        System.out.println(String.format("How much would you like to bet? Your total is %s", player.getTotal()));
        player.gamble(sc.nextInt());

        System.out.println("You are dealt a " + playerCards.get(0).toString());
        System.out.println("The dealer has a " + dealerCards.get(0).toString());
        System.out.println("You are dealt a " + playerCards.get(1).toString());
        System.out.println("The dealer is dealt a face down card");

        if (playerCards.get(0).equals(playerCards.get(1))) {
            System.out.println("You have two of the same cards, would you like to split(y/n): ");

        }

        int playerTotal = getTotal(playerCards);

        if (playerTotal == 21) {
            System.out.println("You got blackjack!");
            player.win(1.5);
            System.out.println(String.format("Your new total is %s", player.getTotal()));
            playing = false;
        }

        /*
        TODO: splitting
        DONE: gambling
        TODO: insurance
        TODO: doubling down
         */

        while (playing) {

            System.out.println("Would you like to hit or stand? (h/s): ");
            char choice = sc.nextLine().charAt(0);

            if (choice == 'h') {
                playerCards.add(deck.deal());
                System.out.println("You are dealt a " + playerCards.get(playerCards.size() - 1).toString());
                System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                playerTotal = getTotal(playerCards);

                containsAce(playerCards);

                if (playerTotal > 21) {
                    System.out.println("You busted and lost! (total: " + playerTotal + ")");
                    player.lose(1);
                    System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                    playing = false;
                }
            } else if (choice == 's') {
                System.out.println("The dealers other card was a " + dealerCards.get(1).toString());
                while (true) {
                    containsAce(dealerCards);
                    if (getTotal(dealerCards) < 17) {
                        dealerCards.add(deck.deal());
                        System.out.println("The dealer is dealt a " + dealerCards.get(dealerCards.size() - 1).toString());
                        System.out.println("Dealers new total: " + getTotal(dealerCards) + "\n");
                    } else if (getTotal(dealerCards) == 21 && dealerCards.size() == 2) {
                        System.out.println("The dealer got blackjack and won!");
                        player.lose(1.5);
                        System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                    } else if (getTotal(dealerCards) > 21) {
                        System.out.println("The dealer busted and you won!");
                        player.win(1);
                        System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                        playing = false;
                        break;
                    } else if (getTotal(dealerCards) >= 17) {
                        int dealerTotal = getTotal(dealerCards);

                        System.out.println("The dealers total is " + dealerTotal);
                        System.out.println("Your total is: " + playerTotal);

                        if (dealerTotal > playerTotal) {
                            System.out.println("You lose!");
                            player.lose(1);
                            System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                        } else if (dealerTotal == playerTotal) {
                            System.out.println("Tie!");
                        } else {
                            System.out.println("You win!");
                            player.win(1);
                            System.out.println("Your new total is " + getTotal(playerCards) + "\n");
                        }
                        playing = false;
                        break;
                    }
                }
            }
        }
        System.out.println("Would you like to play again? (y/n)");

        if (sc.nextLine().toLowerCase().charAt(0) == 'y') {
            main(player);
        } else {
            return;
        }
    }

    private static void containsAce(ArrayList<Card> cards) {
        for (Card c : cards) {
            if (c.rank == RANK.ACE && getTotal(cards) > 21) {
                c.setPoint(1);
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
