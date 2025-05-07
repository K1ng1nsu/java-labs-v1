package chapter9.examples.ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림 API 기본 예제
 * 
 * 이 예제에서는 Java의 스트림 API를 사용한 데이터 처리 방법을 보여줍니다.
 */
public class StreamBasicExample {

    public static void main(String[] args) {
        // 1. 스트림 생성 방법
        System.out.println("===== 스트림 생성 =====");
        
        // 컬렉션에서 스트림 생성
        List<String> fruits = Arrays.asList("사과", "바나나", "오렌지", "포도", "키위");
        Stream<String> fruitStream = fruits.stream();
        
        // 배열에서 스트림 생성
        String[] fruitArray = {"사과", "바나나", "오렌지", "포도", "키위"};
        Stream<String> arrayStream = Arrays.stream(fruitArray);
        
        // Stream.of() 메소드로 스트림 생성
        Stream<String> ofStream = Stream.of("사과", "바나나", "오렌지", "포도", "키위");
        
        // 범위의 정수를 가진 스트림 생성 (1부터 10까지)
        IntStream intStream = IntStream.rangeClosed(1, 10);
        
        // 각 스트림 출력
        System.out.println("컬렉션 스트림:");
        fruitStream.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println("\n배열 스트림:");
        arrayStream.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println("\nof() 메소드 스트림:");
        ofStream.forEach(fruit -> System.out.print(fruit + " "));
        System.out.println("\n정수 범위 스트림:");
        intStream.forEach(num -> System.out.print(num + " "));
        System.out.println();
        
        // 2. 중간 연산 (Intermediate Operations)
        System.out.println("\n===== 중간 연산 =====");
        
        List<String> names = Arrays.asList("윤학생", "김학생", "이학생", "박학생", "손학생", "서학생");
        
        // filter: 조건에 맞는 요소만 필터링
        System.out.println("이름이 '김'으로 시작하는 사람:");
        names.stream()
             .filter(name -> name.startsWith("김"))
             .forEach(System.out::println);
        
        // map: 각 요소를 변환
        System.out.println("\n이름 길이 매핑:");
        names.stream()
             .map(name -> name + ": " + name.length() + "글자")
             .forEach(System.out::println);
        
        // sorted: 요소 정렬
        System.out.println("\n이름 알파벳 순 정렬:");
        names.stream()
             .sorted()
             .forEach(System.out::println);
        
        System.out.println("\n이름 길이순 정렬:");
        names.stream()
             .sorted(Comparator.comparing(String::length))
             .forEach(System.out::println);
        
        // limit: 처음 n개의 요소로 제한
        System.out.println("\n처음 3명만 선택:");
        names.stream()
             .limit(3)
             .forEach(System.out::println);
        
        // skip: 처음 n개의 요소를 건너뜀
        System.out.println("\n처음 3명을 제외한 나머지:");
        names.stream()
             .skip(3)
             .forEach(System.out::println);
        
        // distinct: 중복 제거
        List<String> duplicateNames = Arrays.asList("윤학생", "김학생", "윤학생", "이학생", "김학생");
        System.out.println("\n중복 제거 후:");
        duplicateNames.stream()
                      .distinct()
                      .forEach(System.out::println);
        
        // 3. 최종 연산 (Terminal Operations)
        System.out.println("\n===== 최종 연산 =====");
        
        // forEach: 각 요소에 대한 작업 수행
        System.out.println("forEach 예제:");
        fruits.stream().forEach(fruit -> System.out.print(fruit + " "));
        System.out.println();
        
        // count: 요소 개수 반환
        long count = fruits.stream().count();
        System.out.println("\n과일 개수: " + count);
        
        // anyMatch, allMatch, noneMatch: 조건 검사
        boolean anyLong = fruits.stream().anyMatch(fruit -> fruit.length() > 2);
        boolean allLong = fruits.stream().allMatch(fruit -> fruit.length() > 2);
        boolean noneLong = fruits.stream().noneMatch(fruit -> fruit.length() > 5);
        
        System.out.println("\n길이가 2 초과인 과일이 하나라도 있는가? " + anyLong);
        System.out.println("모든 과일의 길이가 2 초과인가? " + allLong);
        System.out.println("길이가 5 초과인 과일이 없는가? " + noneLong);
        
        // findFirst, findAny: 요소 찾기
        Optional<String> first = fruits.stream().findFirst();
        System.out.println("\n첫 번째 과일: " + first.orElse("없음"));
        
        // reduce: 요소 결합
        Optional<String> combined = fruits.stream()
                                         .reduce((a, b) -> a + ", " + b);
        System.out.println("\n모든 과일 이름 결합: " + combined.orElse("없음"));
        
        // collect: 요소 수집
        List<String> filteredFruits = fruits.stream()
                                           .filter(fruit -> fruit.length() <= 2)
                                           .collect(Collectors.toList());
        System.out.println("\n길이가 2 이하인 과일: " + filteredFruits);
        
        // sum, average, max, min: 숫자 연산 (IntStream 등에서 사용)
        int sum = IntStream.rangeClosed(1, 10).sum();
        double average = IntStream.rangeClosed(1, 10).average().orElse(0);
        int max = IntStream.rangeClosed(1, 10).max().orElse(0);
        int min = IntStream.rangeClosed(1, 10).min().orElse(0);
        
        System.out.println("\n1부터 10까지의 합: " + sum);
        System.out.println("1부터 10까지의 평균: " + average);
        System.out.println("1부터 10까지 중 최댓값: " + max);
        System.out.println("1부터 10까지 중 최솟값: " + min);
    }
} 