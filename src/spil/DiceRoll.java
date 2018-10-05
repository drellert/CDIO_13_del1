package spil;

public class DiceRoll {
    int rolla, rollb;

//  Denne constructor definerer terningernes start værdier
    public DiceRoll(int rollA, int rollB) {
        rolla = rollA;
        rollb = rollB;
    }

//  Returnerer den samlede værdi af spillerens to terningekast
    public int getValue() {
        return rolla + rollb;
    }

//  Returnerer værdierne for spillerens to terningekast, den samlede værdi og spillerens nye pointtotal
    public String toString(int currentTotal, int playerNum) {
        return "Player " + playerNum + " rolled a " + rolla + " and a " + rollb + ". This adds " + getValue() +
               " to their total score." +
               " Player " + playerNum + "'s total score is now " + currentTotal + ".";
    }

//  Tjekker om der er slået to ens
    public boolean isDoubles() {
        return rolla == rollb;
    }

//  Tjekker om der er slået to 1'ere
    public boolean isSnakeeyes() {
        return rolla == 1 && rollb == 1;
    }
}
