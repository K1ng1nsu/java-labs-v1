package chapter5.labs.lab1;

/**
 * Lab 1: 상속과 메소드 오버라이딩
 * <p>
 * Shape 클래스를 정의하세요.
 * 이 클래스는 도형의 기본 속성과 면적을 계산하는 메소드를 가지고 있어야 합니다.
 */
public class Shape {
    // TODO: 도형의 기본 속성 정의 (예: 이름, 색상)
    String name;
    String color;


    // TODO: 생성자 정의

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }


    // TODO: 면적을 계산하는 메소드 정의
    public double calculateArea() {
        return 0;
    }



    // TODO: 도형 정보를 출력하는 메소드 정의

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}