package chapter5.examples.ex2;

/**
 * 추상 클래스 활용 예제
 * Shape, Circle, Rectangle 클래스를 사용하는 예제
 */
public class AbstractClassExample {
    public static void main(String[] args) {
        System.out.println("===== 추상 클래스 활용 예제 =====\n");
        
        // 추상 클래스의 객체는 직접 생성할 수 없음
        // Shape shape = new Shape(); // 컴파일 오류
        
        // Circle 객체 생성 및 테스트
        System.out.println("[1] Circle 객체 생성 및 테스트");
        Circle circle = new Circle("파랑", true, 5.0);
        circle.displayInfo();
        System.out.println("지름: " + circle.getDiameter());
        
        // 반지름 변경
        circle.setRadius(7.5);
        circle.displayInfo();
        
        // Rectangle 객체 생성 및 테스트
        System.out.println("\n[2] Rectangle 객체 생성 및 테스트");
        Rectangle rectangle = new Rectangle("초록", false, 4.0, 6.0);
        rectangle.displayInfo();
        System.out.println("정사각형 여부: " + (rectangle.isSquare() ? "예" : "아니오"));
        
        // 가로, 세로 변경
        rectangle.setWidth(6.0);
        rectangle.displayInfo();
        System.out.println("정사각형 여부: " + (rectangle.isSquare() ? "예" : "아니오"));
        
        // 다형성 활용
        System.out.println("\n[3] 다형성 활용");
        Shape[] shapes = new Shape[2];
        shapes[0] = circle;
        shapes[1] = rectangle;
        
        // 서로 다른 도형들을 동일한 타입(Shape)으로 처리
        System.out.println("\n모든 도형의 면적 합계 계산:");
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
            System.out.println(shape.getClass().getSimpleName() + "의 면적: " + shape.getArea());
        }
        System.out.println("총 면적: " + totalArea);
        
        // 서로 다른 도형들을 동일한 타입(Shape)으로 처리
        System.out.println("\n모든 도형의 둘레 합계 계산:");
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.getPerimeter();
            System.out.println(shape.getClass().getSimpleName() + "의 둘레: " + shape.getPerimeter());
        }
        System.out.println("총 둘레: " + totalPerimeter);

        System.out.println("\n===== 추상 클래스 활용 예제 종료 =====");
    }
} 