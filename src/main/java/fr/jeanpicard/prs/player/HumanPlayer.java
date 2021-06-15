package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.symbol.Symbol;

public class HumanPlayer implements Player {
    private Symbol chosenSymbol;
    private String name;
    private ConsoleHelper consoleHelper;

    public HumanPlayer(String name, ConsoleHelper consoleHelper) {
        this.name = name;
        this.consoleHelper = consoleHelper;
    }

    public Symbol throwSymbol() {
        return chosenSymbol;
    }

    public void chooseSymbol() {
        consoleHelper.displaySymbols();
        chosenSymbol = consoleHelper.pickSymbol();
    }

    public String getName() {
        return name;
    }

}
