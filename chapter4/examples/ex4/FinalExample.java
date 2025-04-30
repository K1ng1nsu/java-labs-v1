package chapter4.examples.ex4;

/**
 * final 키워드 활용 예제
 */
public class FinalExample {
    // final 상수 - 선언과 동시에 초기화
    public static final double PI = 3.14159265359;
    
    // final 필드 - 선언만 하고 생성자에서 초기화 가능
    private final String name;
    
    // final 필드 - 객체 참조 타입(참조 변수는 변경 불가, 객체 내용은 변경 가능)
    private final StringBuilder builder;
    
    public FinalExample(String name) {
        // 생성자에서 final 필드 초기화
        this.name = name;
        this.builder = new StringBuilder("Hello");
    }
    
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("StringBuilder 내용: " + builder);
    }
    
    public void appendToBuilder(String text) {
        // builder = new StringBuilder(); // 에러: final 변수에 새 객체 할당 불가
        builder.append(" ").append(text); // 객체 내용 변경은 가능
    }
    
    // final 메소드 - 오버라이딩 불가
    public final void finalMethod() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }
    
    // 일반 메소드 
    public void normalMethod() {
        // 메소드 내부의 final 지역 변수
        final int count = 10;
        // count = 20; // 에러: final 변수는 값 변경 불가
        
        System.out.println("일반 메소드입니다. count = " + count);
    }
    
    public static void main(String[] args) {
        FinalExample example = new FinalExample("John");
        example.printInfo();
        
        // final 필드 활용
        // example.name = "Robert"; // 에러: final 필드는 값 변경 불가
        
        // final 참조 변수의 객체 내용 변경
        example.appendToBuilder("World");
        example.printInfo();
        
        // final 메소드 호출
        example.finalMethod();
        example.normalMethod();
        
        // final 클래스 사용
        FinalClass finalClass = new FinalClass();
        finalClass.display();
        
        // final 매개변수 활용
        example.methodWithFinalParam(100);
    }
    
    // final 매개변수 예제
    public void methodWithFinalParam(final int param) {
        // param = 200; // 에러: final 매개변수는 값 변경 불가
        System.out.println("final 매개변수 값: " + param);
    }
}

// final 클래스 - 상속 불가
final class FinalClass {
    public void display() {
        System.out.println("이 클래스는 상속할 수 없습니다.");
    }
}

// final 클래스를 상속하려고 시도
// class SubClass extends FinalClass { } // 에러: final 클래스는 상속 불가

// 일반 클래스
class Parent {
    // final 메소드
    public final void cannotOverride() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }
    
    // 일반 메소드
    public void canOverride() {
        System.out.println("Parent: 이 메소드는 오버라이딩 가능합니다.");
    }
}

// 상속 예제
class Child extends Parent {
    // final 메소드 오버라이딩 시도
    // @Override
    // public void cannotOverride() { } // 에러: final 메소드는 오버라이딩 불가
    
    // 일반 메소드 오버라이딩
    @Override
    public void canOverride() {
        System.out.println("Child: 메소드를 오버라이딩했습니다.");
    }
} 