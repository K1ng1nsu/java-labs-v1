package chapter4.examples.ex1;

/**
 * 클래스와 객체의 기본 예제
 * Person 클래스 정의
 */
public class Person {
    // 필드(클래스의 데이터)
    String name;    // 이름
    int age;        // 나이
    String gender;  // 성별
    
    // 메소드(클래스의 기능)
    // 자기소개 메소드
    public void introduce() {
        System.out.println("안녕하세요. 저는 " + name + "입니다.");
        System.out.println("나이는 " + age + "세이고, 성별은 " + gender + "입니다.");
    }
    
    // 나이를 한 살 증가시키는 메소드
    public void addAge() {
        age++;
        System.out.println(name + "의 나이가 1살 증가했습니다. 현재 나이: " + age);
    }
    
    // 이름을 변경하는 메소드
    public void changeName(String newName) {
        System.out.println(name + "의 이름이 " + newName + "으로 변경됩니다.");
        name = newName;
    }
} 