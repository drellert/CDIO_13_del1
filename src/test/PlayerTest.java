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
        snoop.setPoints(36);
        snoop.setCurrentRoll(Optional.of(new DiceRoll(6,6, snoop)));
        assert(snoop.didWin() == false);

        // Test at man taber ved dobbelt 1, selv om man er over de 40 points
        snoop.setPoints(40);
        snoop.setCurrentRoll(Optional.of(new DiceRoll(1,1, snoop)));
        assert(snoop.didWin() == false);

        // Test at man taber ved dobbelt slag, (ikke 1)om man er over de 40 points
        snoop.setPoints(40);
        snoop.setCurrentRoll(Optional.of(new DiceRoll(2,2, snoop)));
        assert(snoop.didWin());

        // Test af at dobbel sekser to gange giver sejr
        snoop.setPoints(3);
        snoop.setCurrentRoll(Optional.of(new DiceRoll(6,6, snoop)));
        snoop.setLastRoll(Optional.of(new DiceRoll(6,6, snoop)));
        assert(snoop.didWin());

    }
}