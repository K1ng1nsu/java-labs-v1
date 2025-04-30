package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * <p>
 * Calculator 클래스를 테스트하는 메인 클래스
 */
public class CalculatorTest {
    public static void main(String[] args) {
        System.out.println("Calculator 클래스 테스트를 시작합니다.");

        // TODO: 클래스 이름으로 static 상수에 접근하여 출력하세요.
        System.out.println(Calculator.PI);


        // TODO: 객체 생성 없이 static 메소드를 호출하여 원의 면적과 둘레를 계산하세요.
        int radius = 5;
        double areaOfCircle = Calculator.getAreaOfCircle(radius);
        double circumference = Calculator.getCircumference(radius);

        System.out.println("areaOfCircle = " + areaOfCircle);
        System.out.println("circumference = " + circumference);

        // TODO: 객체 생성 없이 static 메소드를 호출하여 사각형의 면적을 계산하세요.
        int width = 5;
        int height = 10;

        int areaOfRectangle = Calculator.getAreaOfRectangle(width, height);
        System.out.println("areaOfRectangle = " + areaOfRectangle);

        // TODO: Calculator 객체를 생성하고 인스턴스 메소드를 호출하세요.
        Calculator cal1 = new Calculator("casio-4040");

        // TODO: 생성된 Calculator 객체의 정보를 출력하세요.
        System.out.println(cal1);

        // TODO: 추가로 Calculator 객체를 생성하고, 객체 생성 횟수를 확인하세요.
        Calculator cal2 = new Calculator("casio-4040");

        int numberOfCals = Calculator.getNumberOfCalculator();
        System.out.println("numberOfCals = " + numberOfCals);

        // TODO: 각 객체의 인스턴스 변수 값과 static 변수 값을 비교하세요.

        System.out.println("cal1 count of calculate = " + cal1.countOfCalculation);
        System.out.println("cal2 count of calculate = " + cal2.countOfCalculation);
        System.out.println("is the same? : " + (cal1.countOfCalculation == cal2.countOfCalculation));

        cal1.increaseCountOfCalculation();
        System.out.println("After increaseCountOfCalculation");
        System.out.println("cal1 count of calculate = " + cal1.countOfCalculation);
        System.out.println("cal2 count of calculate = " + cal2.countOfCalculation);
        System.out.println("is the same? : " + (cal1.countOfCalculation == cal2.countOfCalculation));


        System.out.println();


        System.out.println("What about static fields?  : " + (cal1.numberOfCalculator == cal2.numberOfCalculator));
        System.out.println("By the way, it's better not to access class fields through an instance.");

    }
} 