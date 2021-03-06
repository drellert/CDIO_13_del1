package spil;

import spil.Dice;
import spil.DiceRoll;
import java.util.Optional;

public class Player {
    int points = 0; //Sætter antal point til 0
    Optional<DiceRoll> lastRoll = Optional.empty();
    Optional<DiceRoll> currentRoll = Optional.empty();
    Game parent;

    public Player(Game withGame) {
        parent = withGame;
    }

//  Roll opretter en ny terning og ruller to gange og gemmer resultatet i lastRoll
    public void roll(int playerNum) {
        Dice dice = new Dice();
        lastRoll = currentRoll;
        currentRoll = Optional.of(new DiceRoll(dice.roll(), dice.roll(), this));

//      Tjekker om en af spillerne har slået to 1'ere, hvis ja, fjernes alle spillerens point
        if (currentRoll.get().isSnakeeyes()) {
            points=0;
        } else {
            points += currentRoll.get().getValue();
            System.out.println(currentRoll.get().toString(points, playerNum));
        }
    }
//  Tjekker om en af spillerne er har vundet
    public boolean didWin() {
        if (!currentRoll.isPresent()) return false;
        DiceRoll sixRoll = new DiceRoll(6,6,this);
        if (lastRoll.isPresent() && currentRoll.isPresent()
                && currentRoll.get().equals(sixRoll)
                && lastRoll.get().equals(sixRoll))  {
            System.out.println("You rolled two sixes in a row! You won!");
            return true;
        }
        return points >= (40 + currentRoll.get().getValue()) && currentRoll.get().isDoubles();
    }

//    Getters

    public int getPoints() {
        return points;
    }

    public void setPoints(int to) {
        points = to;
    }

    public Optional<DiceRoll> getLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(Optional<DiceRoll> to) {
        lastRoll = to;
        if (to.isPresent()) {
            points += to.get().getValue();
        }
    }

    public Optional<DiceRoll> getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(Optional<DiceRoll> to) {
        currentRoll = to;
        if (to.isPresent()) {
            points += to.get().getValue();
        }
    }
}
