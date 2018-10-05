package spil;

public class Dice {

    public int roll() {
        double d1 = Math.random()*6;
        int faceValue = (int) Math.floor(d1) + 1;
        return faceValue;
    }
}
