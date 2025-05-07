package chapter5.examples.ex1;

/**
 * 상속의 기본 예제
 * Person과 Student 클래스를 사용하는 예제
 */
public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("===== Person 객체 생성 =====");
        Person person = new Person("윤지수", 30);
        person.introduce();
        person.eat();
        person.sleep();
        
        System.out.println("\n===== Student 객체 생성 =====");
        Student student = new Student("전옥길", 20, "202401234", "컴퓨터공학");
        
        System.out.println("\n===== Student 메소드 호출 =====");
        // Person 클래스에서 상속받은 메소드 호출
        student.introduce();
        student.eat();
        student.sleep();
        
        // Student 클래스의 자체 메소드 호출
        student.study();
        student.attendClass();
        student.displayStudentInfo();
        
        System.out.println("\n===== 상속 관계 확인 =====");
        // instanceof 연산자를 사용한 객체 타입 확인
        System.out.println("person은 Person의 인스턴스인가? " + (person instanceof Person));
        System.out.println("student는 Student의 인스턴스인가? " + (student instanceof Student));
        System.out.println("student는 Person의 인스턴스인가? " + (student instanceof Person));
    }
} 