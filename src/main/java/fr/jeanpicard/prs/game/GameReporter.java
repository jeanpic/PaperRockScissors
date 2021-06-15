package fr.jeanpicard.prs.game;

import fr.jeanpicard.prs.player.Player;

import java.util.List;
import java.util.Optional;

public interface GameReporter {

    void reportGame();

    void reportWinner(int roundNumber, Optional<Player> winner);

    void reportRoundChoices(List<Player> players);

}
