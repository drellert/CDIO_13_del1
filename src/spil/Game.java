package spil;

import java.util.Scanner;

public class Game {
    
    public static Scanner input = new Scanner(System.in);
    Player[] players = {new Player(this), new Player(this)};

    public static void main(String[] args) {
        Game g = new Game();
        g.game();
    }

    public void game() {
        int turnIndex = 0;

        System.out.println("Roll two dice and the value of your roll will be added to your total score. Aim for 40 point. "
                + "\nPress enter to roll the dice.");

        boolean explainDoubles = false;

//      Der spilles i en do...while loop, som kører indtil en af spillerne vinder
        do {
//          Sæt player til at være spilleren fra spiller listen ved nuværende tur indeks.
            Player player = players[turnIndex];

//          Sørg for at spilleren trykker på enter for at give en følelse af pride and accomplishment.
            input.nextLine();

//          Slå for spiller med nummer turnIndex + 1.
            player.roll(turnIndex + 1);

//          Hvis en af spillerne overskrider 40 point, forklarer spillet at vedkommende skal slå to ens for at vinde
            if (!explainDoubles && player.points >= 40) {
                System.out.println("A player has reached 40 points or more. In order to win, they must roll doubles.");
                explainDoubles = true;
            }

//          Hvis denne spillers sidste slag ikke er en double, skift spiller indekset så den næste får tur
            if (!player.currentRoll.get().isDoubles()) {
                turnIndex++;
                if (turnIndex == players.length) turnIndex = 0;
            }
        } while (!didAnyPlayerWin());

//      Tjek alle spillere igennem, og find den der vandt.
        for (var i = 0; i < players.length; i++) {
            Player p = players[i];
            if (p.didWin()) {
                System.out.println("Congratulations! Player " + (i + 1) + " won the game with " + p.points + " points.");
            }
        }
    }

//  For alle players i listen player, tjek om de har vundet, ellers retuner false.
    public boolean didAnyPlayerWin() {
        for (Player p: players) {
            if (p.didWin()) return true;
        }
        return false;
    }
}
