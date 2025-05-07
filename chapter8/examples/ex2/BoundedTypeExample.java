package chapter8.examples.ex2;

/**
 * Ex 2: 제네릭 타입 제한 예제
 * 
 * 타입 매개변수에 제한을 두는 제네릭 클래스와 메소드 예제입니다.
 */
public class BoundedTypeExample {
    
    /**
     * 숫자 타입만 받는 제네릭 클래스
     * Number 클래스 또는 그 하위 클래스만 타입으로 지정 가능
     */
    public static class NumericBox<T extends Number> {
        private T value;
        
        public NumericBox(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }
        
        public void setValue(T value) {
            this.value = value;
        }
        
        // Number 클래스의 메소드를 활용할 수 있음
        public double doubleValue() {
            return value.doubleValue();
        }
        
        // 숫자 값 비교
        public boolean isGreaterThan(NumericBox<? extends Number> other) {
            return this.doubleValue() > other.doubleValue();
        }
    }
    
    /**
     * 비교 가능한 객체만 받는 제네릭 메소드
     * @param <T> Comparable 인터페이스를 구현한 타입
     * @param a 첫 번째 객체
     * @param b 두 번째 객체
     * @return 두 객체 중 더 큰 값
     */
    public static <T extends Comparable<T>> T getMax(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
    
    public static void main(String[] args) {
        // 정수형 NumericBox 생성
        NumericBox<Integer> intBox = new NumericBox<>(10);
        System.out.println("정수 박스 값: " + intBox.getValue());
        System.out.println("실수 변환 값: " + intBox.doubleValue());
        
        // 실수형 NumericBox 생성
        NumericBox<Double> doubleBox = new NumericBox<>(5.5);
        System.out.println("실수 박스 값: " + doubleBox.getValue());
        
        // 값 비교
        System.out.println("intBox > doubleBox? " + intBox.isGreaterThan(doubleBox));
        
        // 컴파일 오류 예시 (주석 처리)
        // NumericBox<String> stringBox = new NumericBox<>("Hello"); // String은 Number의 하위 클래스가 아니므로 오류
        
        // getMax 메소드 사용
        System.out.println("\ngetMax 메소드 사용 예:");
        System.out.println("10과 20 중 큰 값: " + getMax(10, 20));
        System.out.println("'apple'과 'banana' 중 사전순 큰 값: " + getMax("apple", "banana"));
        
        // Comparable을 구현한 사용자 정의 클래스 사용
        Person p1 = new Person("윤선생", 25);
        Person p2 = new Person("홍선생", 30);
        Person olderPerson = getMax(p1, p2);
        System.out.println("나이가 많은 사람: " + olderPerson.getName() + ", " + olderPerson.getAge() + "세");
    }
    
    /**
     * Comparable 인터페이스를 구현한 사용자 정의 클래스
     */
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public int compareTo(Person other) {
            // 나이를 기준으로 비교
            return Integer.compare(this.age, other.age);
        }
    }
} 