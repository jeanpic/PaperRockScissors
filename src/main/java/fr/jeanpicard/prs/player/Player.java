package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.symbol.Symbol;

public interface Player {

    public Symbol throwSymbol();

    public void chooseSymbol();

    public String getName();
}
