package fr.jeanpicard.prs.symbol;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

public class SymbolTest {

    @Test
    public void beatsTest(){
        assertTrue(Symbol.PAPER.beats(Symbol.ROCK));
        assertTrue(Symbol.ROCK.beats(Symbol.SCISSORS));
        assertTrue(Symbol.SCISSORS.beats(Symbol.PAPER));
    }

    @Test
    public void getSymbolTest(){
        assertEquals(Symbol.PAPER, Symbol.getSymbol(1));
        assertEquals(Symbol.ROCK, Symbol.getSymbol(2));
        assertEquals(Symbol.SCISSORS, Symbol.getSymbol(3));
        assertThrows(IllegalArgumentException.class, () -> Symbol.getSymbol(4));
    }

    @Test
    public void randomSymbolTest() {
        for(int i = 0; i<Symbol.values().length;i++){
            Random random = Mockito.mock(Random.class);
            Mockito.when(random.nextInt(anyInt())).thenReturn(i);
            Symbol.randomSymbol(random);
        }
    }
}
