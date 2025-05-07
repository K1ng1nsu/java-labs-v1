package chapter5.examples.ex2;

/**
 * 추상 클래스 활용 예제
 * Shape 추상 클래스를 상속받는 Circle 클래스
 */
public class Circle extends Shape {
    // 필드
    private double radius;
    
    /**
     * 기본 생성자
     */
    public Circle() {
        super(); // Shape 클래스의 기본 생성자 호출
        this.radius = 1.0;
    }
    
    /**
     * 매개변수가 있는 생성자
     */
    public Circle(double radius) {
        super(); // Shape 클래스의 기본 생성자 호출
        this.radius = radius;
    }
    
    /**
     * 모든 매개변수를 받는 생성자
     */
    public Circle(String color, boolean filled, double radius) {
        super(color, filled); // Shape 클래스의 매개변수 생성자 호출
        this.radius = radius;
    }
    
    /**
     * 추상 메소드 구현: 원의 면적 계산
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * 추상 메소드 구현: 원의 둘레 계산
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    /**
     * 부모 클래스의 displayInfo 메소드 오버라이딩
     */
    @Override
    public void displayInfo() {
        super.displayInfo(); // 부모 클래스의 메소드 호출
        System.out.println("반지름: " + radius);
    }
    
    /**
     * Circle 클래스에만 있는 메소드: 지름 계산
     */
    public double getDiameter() {
        return 2 * radius;
    }
    
    /**
     * 반지름 설정 시 메시지 출력을 위해 Lombok의 @Setter를 재정의
     */
    public void setRadius(double radius) {
        this.radius = radius;
        System.out.println("원의 반지름이 " + radius + "로 변경되었습니다.");
    }
} 