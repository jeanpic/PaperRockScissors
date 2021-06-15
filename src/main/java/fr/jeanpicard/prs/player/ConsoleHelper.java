package fr.jeanpicard.prs.player;

import fr.jeanpicard.prs.symbol.Symbol;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleHelper {

    public void displaySymbols() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pick your symbol, choosing between: ");
        for(Symbol symbol : Symbol.values()) {
            sb.append(System.lineSeparator());
            sb.append(symbol.numberedSymbol());
        }
        System.out.println(sb.toString());
    }

    public Symbol pickSymbol() {
        Scanner reader = new Scanner(System.in);
        Symbol symbol = null;
        while(symbol == null) {
            try {
                int symbolNumber = reader.nextInt();
                symbol = Symbol.getSymbol(symbolNumber);
            } catch (NoSuchElementException | IllegalArgumentException e) {
                invalidPickEntered();
                reader.next();
            }
        }
        return symbol;
    }

    private void invalidPickEntered() {
        System.out.println("This is not a valid pick.");
        displaySymbols();
    }
}
