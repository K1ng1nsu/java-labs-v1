package chapter5.labs.lab1;

/**
 * Lab 1: 상속과 메소드 오버라이딩
 * 
 * Circle 클래스를 정의하세요.
 * 이 클래스는 Shape 클래스를 상속받아야 합니다.
 */
public class Circle extends Shape {
    // TODO: 원의 속성 정의 (예: 반지름)
    private double radius;

    
    
    // TODO: 생성자 정의

    public Circle(String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }


    // TODO: 부모 클래스의 메소드를 오버라이딩하여 원의 면적을 계산하는 메소드 구현

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }


    // TODO: 부모 클래스의 메소드를 오버라이딩하여 원 정보를 출력하는 메소드 구현

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}