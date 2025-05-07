package chapter8.examples.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ex 2: 제네릭 와일드카드 예제
 * 
 * 와일드카드를 활용한 제네릭 메소드 예제입니다.
 */
public class WildcardExample {
    
    /**
     * 제한 없는 와일드카드를 사용한 메소드
     * 어떤 타입의 리스트든 처리 가능, 타입 안전하게 요소를 꺼내거나 넣을 수 없음
     */
    public static void printList(List<?> list) {
        System.out.println("리스트 내용: " + list);
    }

    /**
     * 상한 제한 와일드카드를 사용한 메소드
     * Number 또는 그 하위 클래스(Integer, Double 등)의 리스트만 받음
     */
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    /**
     * 하한 제한 와일드카드를 사용한 메소드
     * Integer 또는 그 상위 클래스(Number, Object)의 리스트에만 Integer를 추가 가능
     */
    public static void addIntegers(List<? super Integer> list, int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }
    
    public static void main(String[] args) {
        // 다양한 타입의 리스트 생성
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3));
        List<String> stringList = new ArrayList<>(Arrays.asList("one", "two", "three"));

        // 제한 없는 와일드카드 메소드 호출
        System.out.println("=== 제한 없는 와일드카드 ===");
        printList(intList);
        printList(doubleList);
        printList(stringList);
        
        // 상한 제한 와일드카드 메소드 호출
        System.out.println("\n=== 상한 제한 와일드카드 ===");
        System.out.println("정수 리스트 합계: " + sumOfList(intList));
        System.out.println("실수 리스트 합계: " + sumOfList(doubleList));
        // sumOfList(stringList); // 컴파일 오류: String은 Number의 하위 클래스가 아님
        
        // 하한 제한 와일드카드 메소드 호출
        System.out.println("\n=== 하한 제한 와일드카드 ===");
        List<Integer> integersOnly = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        
        addIntegers(integersOnly, 3);
        addIntegers(numbers, 2);
        addIntegers(objects, 1);
        
        System.out.println("Integer 리스트: " + integersOnly);
        System.out.println("Number 리스트: " + numbers);
        System.out.println("Object 리스트: " + objects);
        // addIntegers(doubleList, 3); // 컴파일 오류: List<Double>은 List<? super Integer>가 아님
        
        // 와일드카드의 제약 설명
        List<?> wildcardList = new ArrayList<>(Arrays.asList(1, 2, 3));
        // wildcardList.add(4); // 컴파일 오류: 제한 없는 와일드카드 리스트에는 null 외에 어떤 것도 추가할 수 없음
        wildcardList.clear(); // OK: null 관련 연산은 가능
    }
} 