package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.player.strategies.ComputerStrategy;
import fr.jeanpicard.prs.symbol.Symbol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeAll
    public void setUp() {
        ComputerStrategy strategy = Mockito.mock(ComputerStrategy.class);
        Mockito.when(strategy.chooseSymbol(Mockito.any())).thenReturn(Symbol.ROCK);
        computerPlayer = new ComputerPlayer("Computer", strategy);
    }

    @Test
    public void chooseSymbolTest() {
        assertNull(computerPlayer.throwSymbol());
        computerPlayer.chooseSymbol();
        assertEquals(Symbol.ROCK, computerPlayer.throwSymbol());
    }

    @Test
    public void getNameTest() {
        assertEquals("Computer", computerPlayer.getName());
    }
}
