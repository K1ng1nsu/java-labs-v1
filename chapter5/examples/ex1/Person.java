package chapter5.examples.ex1;

/**
 * 상속의 기본 예제
 * Person 클래스 정의 (부모 클래스)
 */
public class Person {
    // 필드(상속 가능한 필드)
    protected String name;    // 이름
    protected int age;        // 나이
    
    // 생성자
    public Person() {
        this.name = "이름 없음";
        this.age = 0;
        System.out.println("Person 기본 생성자 호출");
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person 매개변수 생성자 호출");
    }
    
    // 메소드
    public void introduce() {
        System.out.println("안녕하세요. 저는 " + name + "입니다.");
        System.out.println("나이는 " + age + "세입니다.");
    }
    
    public void eat() {
        System.out.println(name + "이(가) 식사를 합니다.");
    }
    
    public void sleep() {
        System.out.println(name + "이(가) 잠을 잡니다.");
    }
} 