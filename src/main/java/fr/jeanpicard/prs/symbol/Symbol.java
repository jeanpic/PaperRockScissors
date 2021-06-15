package fr.jeanpicard.prs.symbol;

import java.util.Random;

public enum Symbol {
    PAPER(1), ROCK(2), SCISSORS(3);

    private int value;

    Symbol(int value) {
        this.value = value;
    }

    public boolean beats(Symbol symbol) throws SymbolException {
        switch(this) {
            case PAPER:
                return symbol == ROCK;
            case ROCK:
                return symbol == SCISSORS;
            case SCISSORS:
                return symbol == PAPER;
        }
        throw new SymbolException("This symbol: "+name()+" has no rule specifying which symbol it beats.");
    }

    public static Symbol getSymbol(int value) throws IllegalArgumentException {
        for(Symbol symbol : values()) {
            if(symbol.value == value) {
                return symbol;
            }
        }
        throw new IllegalArgumentException();
    }

    public static Symbol randomSymbol(Random random) {
        return values()[(random.nextInt(values().length))];
    }

    public String numberedSymbol() {
        return value + ". " + name();
    }
}
