package chapter4.examples.ex3;

/**
 * static 키워드 활용 예제
 * Calculator 클래스 정의
 */
public class Calculator {
    // static 상수 (final, static)
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    
    // 인스턴스 변수
    private String color;
    private int batteryPercent;
    
    // static 변수 (클래스 변수)
    private static int calculatorCount = 0;
    
    // 생성자
    public Calculator(String color) {
        this.color = color;
        this.batteryPercent = 100;
        calculatorCount++; // 객체가 생성될 때마다 계산기 수 증가
    }
    
    // 인스턴스 메소드
    public void displayInfo() {
        System.out.println("계산기 색상: " + color);
        System.out.println("배터리: " + batteryPercent + "%");
    }
    
    // 인스턴스 메소드
    public void calculate() {
        if (batteryPercent <= 0) {
            System.out.println("배터리가 없습니다. 충전이 필요합니다.");
            return;
        }
        
        System.out.println("계산 중...");
        batteryPercent -= 10;
        System.out.println("남은 배터리: " + batteryPercent + "%");
    }
    
    // static 메소드 - 원의 넓이 계산
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }
    
    // static 메소드 - 원의 둘레 계산
    public static double calculateCircleCircumference(double radius) {
        return 2 * PI * radius;
    }
    
    // static 메소드 - 계산기 총 개수 반환
    public static int getCalculatorCount() {
        return calculatorCount;
    }
    
    // static 메소드에서는 인스턴스 변수를 직접 사용할 수 없음
    public static void staticMethodExample() {
        // color = "Red"; // 에러: 인스턴스 변수 접근 불가
        // batteryPercent = 50; // 에러: 인스턴스 변수 접근 불가
        // calculate(); // 에러: 인스턴스 메소드 호출 불가
        
        System.out.println("Static 메소드 입니다.");
        System.out.println("현재까지 생성된 계산기 수: " + calculatorCount);
        System.out.println("PI 값: " + PI);
    }
} 