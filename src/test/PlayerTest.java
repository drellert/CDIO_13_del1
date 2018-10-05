package test;
import java.util.Optional;

import org.junit.Test;
import spil.DiceRoll;
import spil.Game;
import spil.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void roll() {
    }

    @Test
    public void didWinTest() {
        // Test, at dobbelt slag først fører til sejr, når man er over 40 points
        Game snoopGame = new Game();
        Player snoop = new Player(snoopGame);
        snoop.points = 36;
        snoop.currentRoll = Optional.of(new DiceRoll(6,6, snoop));
        assert(snoop.didWin() == false);

        // Test at man taber ved dobbelt 1, selv om man er over de 40 points
        snoop.points = 40;
        snoop.currentRoll = Optional.of(new DiceRoll(1,1, snoop));
        assert(snoop.didWin() == false);

        // Test at man taber ved dobbelt slag, (ikke 1)om man er over de 40 points
        snoop.points = 40;
        snoop.currentRoll = Optional.of(new DiceRoll(2,2, snoop));
        assert(snoop.didWin());

        // Test af at dobbel sekser to gange giver sejr
        snoop.points = 3;
        snoop.currentRoll = Optional.of(new DiceRoll(6,6, snoop));
        snoop.lastRoll = Optional.of(new DiceRoll(6,6, snoop));
        assert(snoop.didWin());

    }
}