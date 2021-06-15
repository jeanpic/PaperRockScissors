package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.player.strategies.ComputerStrategy;
import fr.jeanpicard.prs.symbol.Symbol;

public class ComputerPlayer implements Player {
    private ComputerStrategy strategy;
    private Symbol chosenSymbol;
    private String name;

    public ComputerPlayer(String name, ComputerStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Symbol throwSymbol() {
        return chosenSymbol;
    }

    public void chooseSymbol() {
        chosenSymbol = strategy.chooseSymbol(this);
    }

    public String getName() {
        return name;
    }
}
