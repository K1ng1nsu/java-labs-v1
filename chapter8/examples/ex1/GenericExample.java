package chapter8.examples.ex1;

/**
 * Ex 1: 제네릭 클래스 사용 예제
 * 
 * 제네릭 Box 클래스의 활용 예제입니다.
 */
public class GenericExample {
    public static void main(String[] args) {
        // Integer 타입의 Box 생성
        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        
        // String 타입의 Box 생성
        Box<String> stringBox = new Box<>("안녕하세요");
        
        // Double 타입의 Box 생성
        Box<Double> doubleBox = new Box<>(3.14);
        
        // 값 출력
        System.out.println("정수 박스: " + intBox.getItem());
        System.out.println("문자열 박스: " + stringBox.getItem());
        System.out.println("실수 박스: " + doubleBox.getItem());
        
        // 빈 박스 확인
        Box<Character> emptyBox = new Box<>();
        System.out.println("빈 박스 여부: " + emptyBox.isEmpty());
        System.out.println("정수 박스 빈 여부: " + intBox.isEmpty());
        
        // 박스 내용 변경
        intBox.setItem(200);
        System.out.println("정수 박스 변경 후: " + intBox.getItem());
        
        // 컴파일 오류 예시 (주석 처리)
        // intBox.setItem("문자열"); // Integer 타입 박스에 String을 넣으려고 하면 컴파일 오류 발생
        
        // toString 메소드 호출
        System.out.println("정수 박스 toString: " + intBox);
        System.out.println("빈 박스 toString: " + emptyBox);
    }
} 