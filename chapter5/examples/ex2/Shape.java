package chapter5.examples.ex2;

/**
 * 추상 클래스 활용 예제
 * 도형의 기본 속성과 동작을 정의하는 Shape 추상 클래스
 */
public abstract class Shape {
    // 필드
    protected String color;
    protected boolean filled;
    
    /**
     * 기본 생성자
     */
    public Shape() {
        this.color = "빨강";
        this.filled = true;
    }
    
    /**
     * 매개변수가 있는 생성자
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    /**
     * 추상 메소드: 도형의 면적을 계산
     * 하위 클래스는 이 메소드를 반드시 구현해야 함
     */
    public abstract double getArea();
    
    /**
     * 추상 메소드: 도형의 둘레를 계산
     * 하위 클래스는 이 메소드를 반드시 구현해야 함
     */
    public abstract double getPerimeter();
    
    /**
     * 구체적인 메소드: 도형 정보 출력
     * 하위 클래스에서 오버라이딩 가능
     */
    public void displayInfo() {
        System.out.println("\n===== 도형 정보 =====");
        System.out.println("유형: " + getClass().getSimpleName());
        System.out.println("색상: " + color);
        System.out.println("내부 채움: " + (filled ? "채워짐" : "비어있음"));
        System.out.println("면적: " + getArea());
        System.out.println("둘레: " + getPerimeter());
    }
    
    /**
     * 구체적인 메소드: 도형 색상 변경
     */
    public void setColor(String color) {
        this.color = color;
        System.out.println("도형 색상이 " + color + "으로 변경되었습니다.");
    }
    
    /**
     * 구체적인 메소드: 도형 채움 상태 변경
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
        System.out.println("도형 채움 상태가 " + (filled ? "채워짐" : "비어있음") + "으로 변경되었습니다.");
    }
} 