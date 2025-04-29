package chapter3.labs.lab4;

public enum Day {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String korean;

    Day(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }

    public static Day fromKorean(String korean) {
        for (Day day : Day.values()) {
            if (day.korean.equals(korean)) {
                return day;
            }
        }
        throw new IllegalArgumentException("잘못된 요일 이름: " + korean);
    }
}