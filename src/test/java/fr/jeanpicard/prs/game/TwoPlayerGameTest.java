package fr.jeanpicard.prs.game;

import fr.jeanpicard.prs.player.Player;
import fr.jeanpicard.prs.symbol.Symbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TwoPlayerGameTest {
    private TwoPlayerGame twoPlayerGame;

    @BeforeEach
    public void setUp() {
        twoPlayerGame = new TwoPlayerGame();
    }

    @Test
    public void testAddOnePlayer() throws Exception {
        Player player = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player);
        assertEquals(1, twoPlayerGame.getPlayers().size());
        assertTrue(twoPlayerGame.getPlayers().contains(player));
    }

    @Test
    public void testAddTwoPlayer() throws Exception {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        assertEquals(2, twoPlayerGame.getPlayers().size());
        assertTrue(twoPlayerGame.getPlayers().contains(player1));
        assertTrue(twoPlayerGame.getPlayers().contains(player2));
    }

    @Test
    public void addTooManyPlayersTest() throws GameException{
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        Player player3 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        assertThrows(GameException.class,() -> twoPlayerGame.addPlayer(player3));
    }

    @Test
    public void addNullPlayerTest() throws GameException{
        assertThrows(IllegalArgumentException.class,() -> twoPlayerGame.addPlayer(null));
    }

    @Test
    public void addPlayerTwiceTest() throws GameException{
        Player player = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player);
        assertThrows(GameException.class,() -> twoPlayerGame.addPlayer(player));
    }

    @Test
    public void playTest() throws GameException {
        twoPlayerGame = Mockito.spy(TwoPlayerGame.class);
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        Optional<Player> winner = Optional.of(player1);
        Mockito.doReturn(winner).when(twoPlayerGame).determineWinner();
        GameReporter reporter = Mockito.mock(GameReporter.class);
        twoPlayerGame.setGameReporter(reporter);

        int nbOfRounds = 3;
        twoPlayerGame.setNumberOfRounds(nbOfRounds);

        twoPlayerGame.play();

        Mockito.verify(player1, Mockito.times(nbOfRounds)).chooseSymbol();
        Mockito.verify(player2, Mockito.times(nbOfRounds)).chooseSymbol();
        Mockito.verify(reporter, Mockito.times(nbOfRounds)).reportRoundChoices(twoPlayerGame.getPlayers());
        for(int i = 1; i<nbOfRounds; i++){
            Mockito.verify(reporter).reportWinner(i,winner);
        }
        Mockito.verify(reporter).reportGame();
    }

    @Test
    public void player1Wins() throws GameException {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        Symbol symbol1 = Symbol.PAPER;
        Symbol symbol2 = Symbol.ROCK;
        Mockito.when(player1.throwSymbol()).thenReturn(symbol1);
        Mockito.when(player2.throwSymbol()).thenReturn(symbol2);
        assertEquals(Optional.of(player1),twoPlayerGame.determineWinner());
    }


    @Test
    public void player2Wins() throws GameException {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        Symbol symbol1 = Symbol.ROCK;
        Symbol symbol2 = Symbol.PAPER;
        Mockito.when(player1.throwSymbol()).thenReturn(symbol1);
        Mockito.when(player2.throwSymbol()).thenReturn(symbol2);
        assertEquals(Optional.of(player2),twoPlayerGame.determineWinner());
    }

    @Test
    public void roundIsATie() throws GameException {
        Player player1 = Mockito.mock(Player.class);
        Player player2 = Mockito.mock(Player.class);
        twoPlayerGame.addPlayer(player1);
        twoPlayerGame.addPlayer(player2);
        Symbol symbol1 = Symbol.ROCK;
        Symbol symbol2 = Symbol.ROCK;
        Mockito.when(player1.throwSymbol()).thenReturn(symbol1);
        Mockito.when(player2.throwSymbol()).thenReturn(symbol2);
        assertEquals(Optional.empty(),twoPlayerGame.determineWinner());
    }
}
