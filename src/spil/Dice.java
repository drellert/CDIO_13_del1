package spil;

public class Dice {
    public int roll() {
        double d = Math.random() * 6 + 1; //Finder et tal mellem 1 og 6 (med decimaler)
        int faceValue = (int)d; //Fjerner decimaler og omdanner variablen til en integer
        return faceValue;
    }
}
