package fr.jeanpicard.prs.game;

import fr.jeanpicard.prs.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TwoPlayerGameReporter implements GameReporter {

    private Map<Player, Integer> scoreboard;

    public TwoPlayerGameReporter() {
        scoreboard = new HashMap<>();
    }

    public void reportGame() {
        for (Map.Entry<Player, Integer> entry : scoreboard.entrySet()) {
            System.out.println(entry.getKey().getName() + " won "
                    + entry.getValue() + " times.");
        }
    }

    public void reportWinner(int roundNumber, Optional<Player> winner) {
        if(winner.isEmpty()){
            System.out.println("The round "+roundNumber+" was a tie");
        } else {
            Player player = winner.get();
            System.out.println(player.getName()+" won round "+roundNumber);
            scoreboard.merge(player,1,Integer::sum);
        }
    }

    public void reportRoundChoices(List<Player> players) {
        for(Player player: players) {
            System.out.println(player.getName()+": "+player.throwSymbol());
        }
    }

}
