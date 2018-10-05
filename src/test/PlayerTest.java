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
        // Test, at dobbelt slag først fører til sejr, når man er over 40 points
        Player snoop = new Player();
        snoop.points = 36;
        snoop.lastroll = Optional.of(new DiceRoll(6,6));
        assert(snoop.didWin() == false);

        // Test at man taber ved dobbelt 1, selv om man er over de 40 points
        snoop.points = 40;
        snoop.lastroll = Optional.of(new DiceRoll(1,1));
        assert(snoop.didWin() == false);
    }
}