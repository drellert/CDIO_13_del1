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

//    public String toString(int currentTotal) {
//        return "You rolled a " + rolla + " and a " + rollb + ". This adds " + getValue() + " to your total score." +
//               "Your total score is now " + currentTotal + ".";
//    }
}
