package chapter3.labs.lab4;

public enum Operator {
    ADD("+") {
        @Override
        public int calculate(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        @Override
        public int calculate(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int x, int y) {
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Operator getOperator(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }

    // 추상 메소드 (각 상수에서 구현해야 함)
    public abstract int calculate(int x, int y);
}
