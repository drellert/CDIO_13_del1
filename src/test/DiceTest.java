package test;

import org.junit.Test;
import spil.Dice;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void rollTest() {
        Dice vice = new Dice();
        int i = 0;
        int doubleRoll = 0;
        while (i<60000){
            int a = vice.roll();
            int b = vice.roll();
            if (a == b){
                doubleRoll++;
            }
            i++;
        }
        System.out.println(doubleRoll);

        assert((Math.abs(doubleRoll-10000)) < 1000);
    }
}