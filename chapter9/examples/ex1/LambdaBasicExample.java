package chapter9.examples.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 람다식 기본 예제
 * 
 * 이 예제에서는 Java의 람다식과 함수형 인터페이스 사용법을 보여줍니다.
 */
public class LambdaBasicExample {
    
    public static void main(String[] args) {
        // 1. 함수형 인터페이스와 람다식 기본 사용법
        System.out.println("===== 람다식 기본 =====");
        
        // 전통적인 익명 클래스 방식
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("전통적인 방식으로 실행");
            }
        };
        
        // 람다식 방식
        Runnable newWay = () -> System.out.println("람다식 방식으로 실행");
        
        // 실행
        oldWay.run();
        newWay.run();
        
        // 2. Java의 주요 함수형 인터페이스 사용
        System.out.println("\n===== 주요 함수형 인터페이스 =====");
        
        // Predicate<T> - T를 입력받아 boolean 반환 (조건 검사)
        List<String> names = Arrays.asList("윤학생", "김학생", "이학생", "박학생", "손학생");
        
        System.out.println("이름이 3글자인 경우:");
        Predicate<String> isThreeChars = name -> name.length() == 3;
        filterNames(names, isThreeChars);
        
        System.out.println("\n'김'씨 성을 가진 경우:");
        filterNames(names, name -> name.startsWith("김"));
        
        // Consumer<T> - T를 입력받아 소비 (반환값 없음)
        System.out.println("\n모든 이름:");
        Consumer<String> printName = name -> System.out.println("이름: " + name);
        names.forEach(printName);
        
        // Function<T, R> - T를 입력받아 R 타입 반환 (변환)
        System.out.println("\n이름 길이:");
        Function<String, Integer> nameLength = String::length; // 메소드 참조 사용
        names.forEach(name -> System.out.println(name + " -> " + nameLength.apply(name) + "글자"));
        
        // Supplier<T> - 입력 없이 T 타입 결과 반환 (공급)
        System.out.println("\n난수 생성:");
        Supplier<Double> randomValue = Math::random; // 메소드 참조
        for (int i = 0; i < 5; i++) {
            System.out.println("난수: " + randomValue.get());
        }
        
        // 3. 메소드 참조 예제
        System.out.println("\n===== 메소드 참조 =====");
        
        // 정적 메소드 참조
        Function<String, Integer> parseInt = Integer::parseInt;
        System.out.println("문자열 -> 정수: " + parseInt.apply("123"));
        
        // 인스턴스 메소드 참조
        String example = "Hello";
        Supplier<Integer> getLength = example::length;
        System.out.println("문자열 길이: " + getLength.get());
        
        // 생성자 참조
        Supplier<StringBuilder> createBuilder = StringBuilder::new;
        StringBuilder sb = createBuilder.get();
        sb.append("생성자 참조로 생성된 StringBuilder");
        System.out.println(sb.toString());
    }
    
    /**
     * 이름 목록에서 특정 조건에 맞는 이름만 출력하는 메소드
     */
    private static void filterNames(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name);
            }
        }
    }
} 