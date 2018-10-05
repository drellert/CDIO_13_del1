package test;
import java.util.Optional;

import org.junit.Test;
import spil.DiceRoll;
import spil.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void roll() {
    }

    @Test
    public void didWintest() {
        Player snoop = new Player();
        snoop.points = 36;
        snoop.lastroll = Optional.of(new DiceRoll(6,6));
        assert(snoop.didWin() == false);
    }
}