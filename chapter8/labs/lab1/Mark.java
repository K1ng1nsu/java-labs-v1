package chapter8.labs.lab1;

import java.util.List;

public class Mark {
    private static final List<String> marks = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    private final String mark;

    public Mark(String mark) {
        if (!marks.contains(mark)) {
            throw new IllegalArgumentException("Invalid mark");
        }
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
