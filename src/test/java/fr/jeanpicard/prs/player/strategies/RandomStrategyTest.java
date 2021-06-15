package fr.jeanpicard.prs.player.strategies;

import fr.jeanpicard.prs.player.ComputerPlayer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RandomStrategyTest {

    @Test
    public void chooseSymbolTest() {
        ComputerPlayer player = Mockito.mock(ComputerPlayer.class);
        RandomStrategy strategy = new RandomStrategy();
        assertNotNull(strategy.chooseSymbol(player));
    }
}
