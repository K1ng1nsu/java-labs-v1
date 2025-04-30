package chapter3.examples.ex4;

/**
 * 자바의 Enum(열거형) 예제
 */
public class EnumExample {
    public static void main(String[] args) {
        // 기본 Enum 사용
        System.out.println("===== 기본 Enum 사용 =====");
        
        Day today = Day.WEDNESDAY;
        System.out.println("오늘: " + today);
        
        // Enum과 switch 문
        System.out.println("\n===== Enum과 switch 문 =====");
        
        switch (today) {
            case MONDAY:
                System.out.println("월요일 - 한 주의 시작입니다.");
                break;
            case FRIDAY:
                System.out.println("금요일 - 곧 주말입니다!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말 - 휴식 시간입니다.");
                break;
            default:
                System.out.println("평일 - 열심히 일하세요.");
                break;
        }
        
        // Enum의 values() 메소드로 모든 상수 순회
        System.out.println("\n===== Enum의 모든 값 순회 =====");
        for (Day day : Day.values()) {
            System.out.println(day);
        }
        
        // Enum의 ordinal() 메소드로 순서 확인
        System.out.println("\n===== Enum의 ordinal() 메소드 =====");
        System.out.println(Day.MONDAY + "의 순서: " + Day.MONDAY.ordinal());
        System.out.println(Day.SUNDAY + "의 순서: " + Day.SUNDAY.ordinal());

        // 필드와 메소드가 있는 Enum 사용
        System.out.println("\n===== 필드와 메소드가 있는 Enum =====");
        
        Season season = Season.SUMMER;
        System.out.println(season + "의 평균 온도: " + season.getAverageTemperature() + "°C");
        
        for (Season s : Season.values()) {
            System.out.println(s + ": " + s.getDescription() + " (평균 온도: " + s.getAverageTemperature() + "°C)");
        }
        
        // 메소드가 재정의된 Enum 사용
        System.out.println("\n===== 메소드가 재정의된 Enum =====");
        
        Operation add = Operation.ADD;
        Operation subtract = Operation.SUBTRACT;
        
        int x = 10, y = 5;
        System.out.println(x + " " + add + " " + y + " = " + add.calculate(x, y));
        System.out.println(x + " " + subtract + " " + y + " = " + subtract.calculate(x, y));
        
        // 각 Operation 상수에 대해 테스트
        for (Operation op : Operation.values()) {
            System.out.println(x + " " + op + " " + y + " = " + op.calculate(x, y));
        }
        
        // 상태 전이를 구현한 Enum 사용
        System.out.println("\n===== 상태 전이를 구현한 Enum =====");
        
        TaskStatus status = TaskStatus.PENDING;
        System.out.println("초기 상태: " + status);
        
        status = status.nextStatus();
        System.out.println("다음 상태: " + status);
        
        status = status.nextStatus();
        System.out.println("다음 상태: " + status);
        
        status = status.nextStatus();
        System.out.println("다음 상태: " + status);
        
        // 다시 처음으로
        status = status.nextStatus();
        System.out.println("다음 상태: " + status);
    }
}

// 기본 Enum 정의
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// 필드와 메소드가 있는 Enum 정의
enum Season {
    SPRING("꽃이 피는 계절", 15),
    SUMMER("더운 계절", 28),
    FALL("낙엽이 떨어지는 계절", 18),
    WINTER("추운 계절", 5);
    
    private final String description;
    private final int averageTemperature;
    
    // 생성자 (private이 기본값)
    Season(String description, int averageTemperature) {
        this.description = description;
        this.averageTemperature = averageTemperature;
    }
    
    // Getter 메소드
    public String getDescription() {
        return description;
    }
    
    public int getAverageTemperature() {
        return averageTemperature;
    }
}

// 추상 메소드가 있는 Enum 정의
enum Operation {
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
    
    Operation(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return symbol;
    }
    
    // 추상 메소드 (각 상수에서 구현해야 함)
    public abstract int calculate(int x, int y);
}

// 상태 전이를 구현한 Enum 정의
enum TaskStatus {
    READY {
        @Override
        public TaskStatus nextStatus() {
            return PENDING;
        }
    },
    PENDING {
        @Override
        public TaskStatus nextStatus() {
            return IN_PROGRESS;
        }
    },
    IN_PROGRESS {
        @Override
        public TaskStatus nextStatus() {
            return COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public TaskStatus nextStatus() {
            return ARCHIVED;
        }
    },
    ARCHIVED {
        @Override
        public TaskStatus nextStatus() {
            return PENDING; // 다시 처음으로
        }
    };
    
    // 상태 전이를 위한 추상 메소드
    public abstract TaskStatus nextStatus();
} 