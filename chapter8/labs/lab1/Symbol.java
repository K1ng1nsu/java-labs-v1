package chapter8.labs.lab1;

import java.util.List;

public class Symbol {
    private static final List<String> symbols = List.of("heart","diamond","clover","spade");
    private final String symbol;

    public Symbol(String symbol) {

        // heart diamond clover spade

        if (!symbols.contains(symbol)) {
            throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }

        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
