package spil;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner input = new Scanner(System.in);

        System.out.println("Press enter to roll the dice.");

        do {
            input.nextLine();

            //Player 1's tur:
            player1.roll(1);

            input.nextLine();

            //Player 2's tur
            player2.roll(2);
        } while (!player1.didWin() && !player2.didWin());

        if (player1.didWin()) {
            System.out.println("Congratulations! Player 1 won the game with " + player1.points + " points.");
        } else {
            System.out.println("Congratulations! Player 2 won the game with " + player2.points + " points.");
        }
    }
}
