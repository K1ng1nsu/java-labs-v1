package chapter5.examples.ex2;

/**
 * 추상 클래스 활용 예제
 * Shape 추상 클래스를 상속받는 Rectangle 클래스
 */
public class Rectangle extends Shape {
    // 필드
    private double width;
    private double height;
    
    /**
     * 기본 생성자
     */
    public Rectangle() {
        super(); // Shape 클래스의 기본 생성자 호출
        this.width = 1.0;
        this.height = 1.0;
    }
    
    /**
     * 매개변수가 있는 생성자
     */
    public Rectangle(double width, double height) {
        super(); // Shape 클래스의 기본 생성자 호출
        this.width = width;
        this.height = height;
    }
    
    /**
     * 모든 매개변수를 받는 생성자
     */
    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled); // Shape 클래스의 매개변수 생성자 호출
        this.width = width;
        this.height = height;
    }
    
    /**
     * 추상 메소드 구현: 사각형의 면적 계산
     */
    @Override
    public double getArea() {
        return width * height;
    }
    
    /**
     * 추상 메소드 구현: 사각형의 둘레 계산
     */
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    /**
     * 부모 클래스의 displayInfo 메소드 오버라이딩
     */
    @Override
    public void displayInfo() {
        super.displayInfo(); // 부모 클래스의 메소드 호출
        System.out.println("가로: " + width);
        System.out.println("세로: " + height);
    }
    
    /**
     * Rectangle 클래스에만 있는 메소드: 정사각형인지 확인
     */
    public boolean isSquare() {
        return width == height;
    }
    
    /**
     * 가로 길이 설정 시 메시지 출력을 위해 Lombok의 @Setter를 재정의
     */
    public void setWidth(double width) {
        this.width = width;
        System.out.println("사각형의 가로 길이가 " + width + "로 변경되었습니다.");
    }
    
    /**
     * 세로 길이 설정 시 메시지 출력을 위해 Lombok의 @Setter를 재정의
     */
    public void setHeight(double height) {
        this.height = height;
        System.out.println("사각형의 세로 길이가 " + height + "로 변경되었습니다.");
    }
} 