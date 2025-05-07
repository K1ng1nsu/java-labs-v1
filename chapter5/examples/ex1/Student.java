package chapter5.examples.ex1;

/**
 * 상속의 기본 예제
 * Student 클래스 정의 (Person 클래스를 상속)
 */
public class Student extends Person {
    // 추가 필드
    private String studentId;  // 학번
    private String major;      // 전공
    
    // 생성자
    public Student() {
        // 부모 클래스의 기본 생성자 호출 (생략 가능, 자동 호출됨)
        super();
        this.studentId = "00000000";
        this.major = "미정";
        System.out.println("Student 기본 생성자 호출");
    }
    
    public Student(String name, int age, String studentId, String major) {
        // 부모 클래스의 매개변수 생성자 호출
        super(name, age);
        this.studentId = studentId;
        this.major = major;
        System.out.println("Student 매개변수 생성자 호출");
    }
    
    // 추가 메소드
    public void study() {
        System.out.println(name + "이(가) 공부를 합니다.");
    }
    
    public void attendClass() {
        System.out.println(name + "이(가) 수업에 참여합니다.");
    }
    
    // 학생 정보 출력 메소드
    public void displayStudentInfo() {
        System.out.println("===== 학생 정보 =====");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("학번: " + studentId);
        System.out.println("전공: " + major);
    }

    @Override
    public void introduce() {
        System.out.println("안녕하세요. 저는 학생 " + name + "입니다.");
        System.out.println("나이는 " + age + "세입니다.");
    }
}