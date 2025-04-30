package chapter4.examples.ex3;

/**
 * static 멤버 활용 예제
 */
public class CalculatorExample {
    public static void main(String[] args) {
        // static 메소드는 객체 생성 없이 클래스 이름으로 직접 호출 가능
        System.out.println("원의 넓이(반지름 5): " + Calculator.calculateCircleArea(5));
        System.out.println("원의 둘레(반지름 5): " + Calculator.calculateCircleCircumference(5));
        
        // static 변수 사용
        System.out.println("PI 값: " + Calculator.PI);
        System.out.println("현재 생성된 계산기 수: " + Calculator.getCalculatorCount());
        
        System.out.println("\n--- 계산기 객체 생성 ---");
        // 객체 생성 및 사용
        Calculator calc1 = new Calculator("Red");
        calc1.displayInfo();
        calc1.calculate();
        
        // static 메소드/변수는 객체를 통해서도 접근 가능
        // 하지만 클래스 이름으로 접근하는 것이 바람직함
        System.out.println("\n원의 넓이(반지름 3): " + calc1.calculateCircleArea(3)); // 권장하지 않음
        
        System.out.println("\n현재 생성된 계산기 수: " + Calculator.getCalculatorCount());
        
        System.out.println("\n--- 계산기 객체 추가 생성 ---");
        Calculator calc2 = new Calculator("Blue");
        calc2.displayInfo();
        
        System.out.println("\n현재 생성된 계산기 수: " + Calculator.getCalculatorCount());
        
        // static 메소드 호출
        Calculator.staticMethodExample();
        
        System.out.println("\n--- 인스턴스 변수 vs static 변수 ---");
        // 인스턴스 변수: 각 객체마다 별도로 생성됨
        calc1.calculate(); // 배터리 소모
        calc1.calculate(); // 배터리 소모
        calc1.displayInfo(); // calc1의 배터리만 감소
        calc2.displayInfo(); // calc2의 배터리는 그대로
        
        // static 변수: 모든 객체가 공유
        System.out.println("\n현재 생성된 계산기 수: " + Calculator.getCalculatorCount());
    }
} 