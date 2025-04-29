package chapter3.labs.lab4;

public enum Season {
    SPRING("봄","꽃이 피는 계절", 15),
    SUMMER("여름","더운 계절", 28),
    FALL("가을","낙엽이 떨어지는 계절", 18),
    WINTER("겨울","추운 계절", 5);

    private final String korean;
    private final String description;
    private final int averageTemperature;

    // 생성자 (private이 기본값)
    Season(String korean,String description, int averageTemperature) {
        this.korean = korean;
        this.description = description;
        this.averageTemperature = averageTemperature;
    }

    // Getter 메소드


    public String getKorean() {
        return korean;
    }

    public String getDescription() {
        return description;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public static Season getSeasonByNumOfMonth(int numOfMonth) {
        // 12, 1, 2 Winter
        // 3, 4, 5 Spring
        // 6, 7, 8 Summer
        // 9, 10, 11 fall
        switch (numOfMonth) {
            case 12, 1, 2:
                return WINTER;
            case 3, 4, 5:
                return SPRING;
            case 6, 7, 8:
                return SUMMER;
            case 9, 10, 11:
                return FALL;
        }
        throw new IllegalArgumentException("잘못된 입력.");
    }
}
