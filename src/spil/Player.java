package spil;
import spil.Dice;
import spil.DiceRoll;
import java.util.Optional;

public class Player {
    public int points = 0; //Sætter antal point til 0
    public Optional<DiceRoll> lastroll = Optional.empty();

    // Roll opretter en ny terning og ruller to gange og gemmer resultatet i lastroll.
    public void roll(int playerNum) {
        Dice dice = new Dice();
        lastroll = Optional.of(new DiceRoll(dice.roll(),dice.roll()));

        // Tjekker om en af spillerne har slået to 1'ere, hvis ja, fjernes alle spillerens point
        if (lastroll.get().isSnakeeyes()) {
            points=0;
            System.out.println("You rolled snakeeyes, and lost all your points.");
        } else {
            points += lastroll.get().getValue();

            System.out.println(lastroll.get().toString(points, playerNum));
        }
    }
    // Tjekker om en af spillerne er kommet over 40 point
    public boolean didWin() {
        if (!lastroll.isPresent()) return false;
        return points >= (40 + lastroll.get().getValue()) && lastroll.get().isDoubles();
    }
}
