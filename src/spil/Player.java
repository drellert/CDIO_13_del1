package spil;

import java.util.Optional;

public class Player {
    int points = 0; //Sætter antal point til 0
    Optional<DiceRoll> lastroll = Optional.empty();

    public void roll(int playerNum) {
        Dice dice = new Dice();
        int eye1, eye2;
        eye1 = dice.roll();
        eye2 = dice.roll();
        lastroll = Optional.of(new DiceRoll(eye1,eye2));

        points += lastroll.get().getValue();

         System.out.println(lastroll.get().toString(points, playerNum));
    }

    public boolean didWin() {
        if (!lastroll.isPresent()) return false;
        return points >= (40 + lastroll.get().getValue()) && lastroll.get().isDoubles();
    }
}
