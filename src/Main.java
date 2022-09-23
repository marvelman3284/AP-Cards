import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        Blackjack.main();
        Player jeevan = new Player("Jeevan");
        jeevan.gamble(50);
        jeevan.win(1);
        System.out.println(jeevan.getTotal());
        System.out.println(jeevan);
    }

}