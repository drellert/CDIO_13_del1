package spil;

public class DiceRoll {
    int rolla, rollb;
    Player parent;

//  Denne constructor definerer terningernes start værdier
    public DiceRoll(int rollA, int rollB, Player withParent) {
        rolla = rollA;
        rollb = rollB;
        parent = withParent;
    }

//  Returnerer den samlede værdi af spillerens to terningekast
    public int getValue() {
        return rolla + rollb;
    }

//  Tjekker om der er slået to 1'ere
    public boolean isSnakeeyes() {
        return rolla == 1 && rollb == 1;
    }

//  Tjekker om der er slået to ens
    public boolean isDoubles() {
        if(isSnakeeyes()) return false;
        return rolla == rollb;
    }

//  Returnerer værdierne for spillerens to terningekast, den samlede værdi og spillerens nye pointtotal
//  samt evt. straf/belønning
    public String toString(int currentTotal, int playerNum) {
        if (isSnakeeyes()) return "They rolled snakeeyes, and lost all their points.";
        if (isDoubles() && !parent.parent.didAnyPlayerWin()) {
            return "Player " + playerNum + " rolled a " + rolla +" and a " + rollb + ". This adds " +
                    getValue() + " to their total score." + " Player " + playerNum + "'s total score is now "
                    + currentTotal + ".\nThey rolled doubles, and get another turn.";
        }
        return "Player " + playerNum + " rolled a " + rolla + " and a " + rollb + ". This adds " + getValue() +
                " to their total score." +
                " Player " + playerNum + "'s total score is now " + currentTotal + ".";
    }
}
