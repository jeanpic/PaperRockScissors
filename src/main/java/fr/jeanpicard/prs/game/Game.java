package fr.jeanpicard.prs.game;

import fr.jeanpicard.prs.player.Player;

import java.util.Optional;

public interface Game {

    void addPlayer(Player player) throws GameException;

    void setNumberOfRounds(int numberOfRounds);

    void setGameReporter(GameReporter reporter);

    void play();

    Optional<Player> determineWinner();
}
