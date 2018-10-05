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
}
