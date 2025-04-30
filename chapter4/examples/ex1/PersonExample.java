package chapter4.examples.ex1;

/**
 * Person 클래스를 사용하는 예제
 */
public class PersonExample {
    public static void main(String[] args) {
        // Person 객체 생성
        Person person1 = new Person();
        
        // 객체의 필드 값 설정
        person1.name = "John";
        person1.age = 25;
        person1.gender = "Male";
        
        // person1 객체의 메소드 호출
        person1.introduce();
        person1.addAge();
        person1.changeName("Johnny");
        person1.introduce();
        
        System.out.println("--------------------");
        
        // 두 번째 Person 객체 생성 및 사용
        Person person2 = new Person();
        person2.name = "Emma";
        person2.age = 28;
        person2.gender = "Female";
        person2.introduce();
        
        System.out.println("--------------------");
        
        // 배열을 이용한 여러 Person 객체 관리
        Person[] people = new Person[3];
        
        // 배열에 객체 할당
        people[0] = person1;
        people[1] = person2;
        
        // 배열에 새 객체 생성해서 할당
        people[2] = new Person();
        people[2].name = "Michael";
        people[2].age = 30;
        people[2].gender = "Male";
        
        // 배열을 순회하며 객체 사용
        System.out.println("사람 목록:");
        for (Person p : people) {
            p.introduce();
            System.out.println();
        }
    }
} 