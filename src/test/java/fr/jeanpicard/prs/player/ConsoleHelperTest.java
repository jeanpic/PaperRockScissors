package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.symbol.Symbol;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConsoleHelperTest {

    private ConsoleHelper consoleHelper;

    @BeforeAll
    public void setUp() {
        consoleHelper = new ConsoleHelper();
    }

    @Test
    public void displaySymbolsTest() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        System.setOut(out);
        consoleHelper.displaySymbols();
        InputStream in = new ByteArrayInputStream(os.toByteArray());
        assertEquals("Pick your symbol, choosing between: "+System.lineSeparator()+"1. PAPER"+System.lineSeparator()+"2. ROCK"+System.lineSeparator()+"3. SCISSORS"+System.lineSeparator(),readInputStream(in));
    }

    @Test
    public void pickSymbolTest() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Symbol symbol = consoleHelper.pickSymbol();
        assertEquals(Symbol.ROCK,symbol);

        input = "4";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class, () -> consoleHelper.pickSymbol());
    }

    public String readInputStream(InputStream in) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = in.read(buffer)) != -1; ) {
            result.write(buffer, 0, length);
        }
        return result.toString();
    }
}
