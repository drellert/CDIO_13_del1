package spil;

public class DiceRoll {
    int rolla, rollb;

    public DiceRoll(int rollA, int rollB) {
        rolla = rollA;
        rollb = rollB;
    }

    public int getValue() {
        return rolla + rollb;
    }

    public String toString(int currentTotal, int playerNum) {
        return "Player " + playerNum + " rolled a " + rolla + " and a " + rollb + ". This adds " + getValue() +
               " to their total score." +
               " Player " + playerNum + "'s total score is now " + currentTotal + ".";
    }

    public boolean isDoubles() {
        return rolla == rollb;
    }

    public boolean isSnakeeyes() {
        return rolla == 1 && rollb == 1;
    }
}
