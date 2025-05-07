package chapter8.examples.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Ex 3: ArrayList 활용 예제
 * 
 * ArrayList의 기본 사용법과 다양한 메소드를 보여주는 예제입니다.
 */
public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList 생성
        List<String> fruits = new ArrayList<>();
        
        // 요소 추가
        System.out.println("=== 요소 추가 ===");
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        System.out.println("과일 목록: " + fruits);
        
        // 특정 위치에 요소 추가
        fruits.add(1, "포도");
        System.out.println("포도 추가 후 목록: " + fruits);
        
        // 요소 개수 확인
        System.out.println("과일 개수: " + fruits.size());
        
        // 요소 가져오기
        System.out.println("\n=== 요소 접근 ===");
        String firstFruit = fruits.get(0);
        System.out.println("첫 번째 과일: " + firstFruit);
        
        // 요소 포함 여부 확인
        boolean containsApple = fruits.contains("사과");
        System.out.println("사과 포함 여부: " + containsApple);
        
        // 요소의 인덱스 찾기
        int bananaIndex = fruits.indexOf("바나나");
        System.out.println("바나나의 인덱스: " + bananaIndex);
        
        // 요소 변경
        System.out.println("\n=== 요소 변경 ===");
        fruits.set(0, "청사과");
        System.out.println("사과를 청사과로 변경: " + fruits);
        
        // 요소 삭제
        System.out.println("\n=== 요소 삭제 ===");
        fruits.remove("오렌지");
        System.out.println("오렌지 삭제 후: " + fruits);
        
        // 인덱스로 요소 삭제
        fruits.remove(1);
        System.out.println("인덱스 1 삭제 후: " + fruits);
        
        // 리스트 추가
        List<String> moreFruits = new ArrayList<>();
        moreFruits.add("키위");
        moreFruits.add("망고");
        
        fruits.addAll(moreFruits);
        System.out.println("추가 과일 목록 추가 후: " + fruits);
        
        // 반복문을 사용한 리스트 순회
        System.out.println("\n=== 리스트 순회 방법 ===");
        
        // 1. 기본 for 문
        System.out.println("1. 기본 for 문:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("  과일 " + i + ": " + fruits.get(i));
        }
        
        // 2. 향상된 for 문 (for-each)
        System.out.println("\n2. 향상된 for 문:");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }
        
        // 3. Iterator 사용
        System.out.println("\n3. Iterator 사용:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("  " + fruit);
        }
        
        // 4. forEach 메소드 (Java 8)
        System.out.println("\n4. forEach 메소드:");
        fruits.forEach(fruit -> System.out.println("  " + fruit));
        
        // 정렬 (Collections 클래스 사용)
        System.out.println("\n=== 정렬 ===");
        Collections.sort(fruits);
        System.out.println("정렬 후: " + fruits);
        
        // 역순 정렬
        Collections.reverse(fruits);
        System.out.println("역순 정렬 후: " + fruits);
        
        // 모든 요소 삭제
        System.out.println("\n=== 리스트 비우기 ===");
        fruits.clear();
        System.out.println("모든 요소 삭제 후: " + fruits);
        System.out.println("리스트가 비어있나요? " + fruits.isEmpty());
    }
} 