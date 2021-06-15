package fr.jeanpicard.prs.game;

import fr.jeanpicard.prs.symbol.Symbol;
import fr.jeanpicard.prs.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TwoPlayerGame implements Game {
    private static final int MAX_PLAYERS=2;

    private List<Player> players;
    private GameReporter reporter;
    private int numberOfRounds = 1;


    public TwoPlayerGame(){
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) throws GameException {
        if(players.size() == MAX_PLAYERS)
            throw new GameException("Max players already reached!");
        if(player == null) {
            throw new IllegalArgumentException("Player is null!");
        }
        if(!players.contains(player)) {
            players.add(player);
        } else {
            throw new GameException("Player is already in the game!");
        }
    }

    public void play() {
        int roundNumber = 1;
        while(roundNumber <= numberOfRounds) {
            for(Player player: players) {
                player.chooseSymbol();
            }
            reporter.reportRoundChoices(players);
            Optional<Player> winner = determineWinner();
            reporter.reportWinner(roundNumber,winner);
            roundNumber++;
        }
        reporter.reportGame();
    }

    public Optional<Player> determineWinner() {
        Symbol player1Symbol = players.get(0).throwSymbol();
        Symbol player2Symbol = players.get(1).throwSymbol();

        if(player1Symbol.equals(player2Symbol)) {
            return Optional.empty();
        } else if (player1Symbol.beats(player2Symbol)) {
            return Optional.of(players.get(0));
        } else {
            return Optional.of(players.get(1));
        }
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setGameReporter(GameReporter reporter) {
        this.reporter = reporter;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
