package spil;
import spil.Dice;
import spil.DiceRoll;
import java.util.Optional;

public class Player {
    public int points = 0; //Sætter antal point til 0
    public Optional<DiceRoll> lastRoll = Optional.empty();
    public Optional<DiceRoll> currentRoll = Optional.empty();

    // Roll opretter en ny terning og ruller to gange og gemmer resultatet i lastRoll.
    public void roll(int playerNum) {
        Dice dice = new Dice();
        lastRoll = currentRoll;
        currentRoll = Optional.of(new DiceRoll(dice.roll(),dice.roll()));

        // Tjekker om en af spillerne har slået to 1'ere, hvis ja, fjernes alle spillerens point
        if (currentRoll.get().isSnakeeyes()) {
            points=0;
            System.out.println("You rolled snakeeyes, and lost all your points.");
        } else {
            points += currentRoll.get().getValue();

            System.out.println(currentRoll.get().toString(points, playerNum));
        }
    }
    // Tjekker om en af spillerne er kommet over 40 point
    public boolean didWin() {
        if (!currentRoll.isPresent()) return false;
        if (lastRoll.isPresent()
                && currentRoll.get() == new DiceRoll(6,6)
                && lastRoll.get() == new DiceRoll(6,6)) {
            System.out.println("Two sixes! You won!");
            return true;
        }
        return points >= (40 + currentRoll.get().getValue()) && currentRoll.get().isDoubles();
    }
}
