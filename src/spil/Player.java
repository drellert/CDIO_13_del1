import spil.DiceRoll;

import java.util.Optional;
package spil;

public class Player {
    int points = 0; //Sætter antal point til 0
    Optional<DiceRoll> lastroll = Optional.empty();

    public void roll() {
        Dice dice = new Dice();
        int eye1, eye2;
        eye1 = dice.roll();
        eye2 = dice.roll();
        lastroll = Optional.of(new DiceRoll(eye1,eye2));

        points += lastroll.get().getValue();
    }

    public boolean didWin() {
        return points >= 40;
    }

}
