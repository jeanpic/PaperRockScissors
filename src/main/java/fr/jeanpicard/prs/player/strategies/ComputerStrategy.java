package fr.jeanpicard.prs.player.strategies;

import fr.jeanpicard.prs.player.Player;
import fr.jeanpicard.prs.symbol.Symbol;

public interface ComputerStrategy {
    Symbol chooseSymbol(Player player);
}

