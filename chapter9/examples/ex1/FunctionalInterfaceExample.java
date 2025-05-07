package chapter9.examples.ex1;

/**
 * 함수형 인터페이스 예제
 * 
 * 이 예제에서는 사용자 정의 함수형 인터페이스를 만들고 사용하는 방법을 보여줍니다.
 */
public class FunctionalInterfaceExample {

    // @FunctionalInterface 어노테이션은 인터페이스가 함수형 인터페이스임을 명시적으로 선언합니다.
    // 함수형 인터페이스는 오직 하나의 추상 메소드만 가질 수 있습니다.
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
        
        // 디폴트 메소드는 함수형 인터페이스에 여러 개 존재할 수 있습니다.
        default void printInfo() {
            System.out.println("이것은 계산기 인터페이스입니다.");
        }
        
        // 정적 메소드도 함수형 인터페이스에 여러 개 존재할 수 있습니다.
        static Calculator add() {
            return (a, b) -> a + b;
        }
        
        static Calculator subtract() {
            return (a, b) -> a - b;
        }
        
        static Calculator multiply() {
            return (a, b) -> a * b;
        }
        
        static Calculator divide() {
            return (a, b) -> b != 0 ? a / b : 0;
        }
    }
    
    @FunctionalInterface
    interface StringProcessor {
        String process(String input);
        
        default StringProcessor andThen(StringProcessor after) {
            return input -> after.process(this.process(input));
        }
    }

    public static void main(String[] args) {
        // 1. 기본 람다식 사용
        System.out.println("===== 기본 람다식 계산기 =====");
        
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;
        Calculator divide = (a, b) -> b != 0 ? a / b : 0;
        
        int a = 10, b = 5;
        System.out.println(a + " + " + b + " = " + add.calculate(a, b));
        System.out.println(a + " - " + b + " = " + subtract.calculate(a, b));
        System.out.println(a + " * " + b + " = " + multiply.calculate(a, b));
        System.out.println(a + " / " + b + " = " + divide.calculate(a, b));
        
        // 디폴트 메소드 호출
        add.printInfo();
        
        // 2. 정적 팩토리 메소드 사용
        System.out.println("\n===== 정적 팩토리 메소드 사용 =====");
        Calculator addFromStatic = Calculator.add();
        Calculator subtractFromStatic = Calculator.subtract();
        
        System.out.println(a + " + " + b + " = " + addFromStatic.calculate(a, b));
        System.out.println(a + " - " + b + " = " + subtractFromStatic.calculate(a, b));
        
        // 3. 함수 합성 예제
        System.out.println("\n===== 함수 합성 =====");
        StringProcessor toUpperCase = s -> s.toUpperCase();
        StringProcessor addExclamation = s -> s + "!";
        
        // 함수 합성: 먼저 대문자로 변환하고, 그 다음 느낌표 추가
        StringProcessor composedProcessor = toUpperCase.andThen(addExclamation);
        
        String input = "hello";
        System.out.println("원본: " + input);
        System.out.println("대문자: " + toUpperCase.process(input));
        System.out.println("느낌표 추가: " + addExclamation.process(input));
        System.out.println("합성 함수: " + composedProcessor.process(input));
    }
} 