package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.symbol.Symbol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanPlayerTest {

    private HumanPlayer humanPlayer;

    @BeforeAll
    public void setUp() {
        ConsoleHelper consoleHelper = Mockito.mock(ConsoleHelper.class);
        Mockito.when(consoleHelper.pickSymbol()).thenReturn(Symbol.PAPER);
        humanPlayer = new HumanPlayer("human",consoleHelper);
    }

    @Test
    public void chooseSymbolTest() {
        assertNull(humanPlayer.throwSymbol());
        humanPlayer.chooseSymbol();
        assertNotNull(humanPlayer.throwSymbol());
    }

    @Test
    public void getNameTest() {
        assertEquals("human", humanPlayer.getName());
    }
}
