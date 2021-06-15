package fr.jeanpicard.prs.player.strategies;

import fr.jeanpicard.prs.player.Player;
import fr.jeanpicard.prs.symbol.Symbol;

import java.util.Random;

public class RandomStrategy implements ComputerStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public Symbol chooseSymbol(Player player) {
        return Symbol.randomSymbol(RANDOM);
    }
}
