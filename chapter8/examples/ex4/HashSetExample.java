package chapter8.examples.ex4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Ex 4: HashSet 예제
 * 
 * HashSet의 기본 사용법과 특징을 보여주는 예제입니다.
 */
public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 생성
        Set<String> fruits = new HashSet<>();
        
        // 요소 추가
        System.out.println("=== 요소 추가 ===");
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");
        fruits.add("포도");
        System.out.println("과일 목록: " + fruits);
        
        // 중복 요소 추가 시도
        System.out.println("\n=== 중복 요소 추가 ===");
        boolean added = fruits.add("사과");
        System.out.println("'사과' 추가 성공? " + added);
        System.out.println("중복 추가 후 과일 목록: " + fruits);
        
        // 요소 개수 확인
        System.out.println("\n요소 개수: " + fruits.size());
        
        // 요소 포함 여부 확인
        System.out.println("\n=== 요소 존재 확인 ===");
        boolean containsApple = fruits.contains("사과");
        System.out.println("'사과' 포함 여부: " + containsApple);
        boolean containsMango = fruits.contains("망고");
        System.out.println("'망고' 포함 여부: " + containsMango);
        
        // 요소 순회 방법
        System.out.println("\n=== HashSet 순회 방법 ===");
        
        // 1. 향상된 for 문 (for-each)
        System.out.println("1. 향상된 for 문:");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }
        
        // 2. Iterator 사용
        System.out.println("\n2. Iterator 사용:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("  " + fruit);
        }
        
        // 3. forEach 메소드 (Java 8)
        System.out.println("\n3. forEach 메소드:");
        fruits.forEach(fruit -> System.out.println("  " + fruit));
        
        // 요소 삭제
        System.out.println("\n=== 요소 삭제 ===");
        fruits.remove("바나나");
        System.out.println("'바나나' 삭제 후: " + fruits);
        
        // 다른 Set과의 연산
        System.out.println("\n=== Set 연산 ===");
        Set<String> otherFruits = new HashSet<>();
        otherFruits.add("사과");
        otherFruits.add("키위");
        otherFruits.add("망고");
        
        System.out.println("otherFruits: " + otherFruits);
        
        // 합집합 (union)
        Set<String> union = new HashSet<>(fruits);
        union.addAll(otherFruits);
        System.out.println("합집합: " + union);
        
        // 교집합 (intersection)
        Set<String> intersection = new HashSet<>(fruits);
        intersection.retainAll(otherFruits);
        System.out.println("교집합: " + intersection);
        
        // 차집합 (difference)
        Set<String> difference = new HashSet<>(fruits);
        difference.removeAll(otherFruits);
        System.out.println("차집합 (fruits - otherFruits): " + difference);
        
        // 모든 요소 삭제
        System.out.println("\n=== Set 비우기 ===");
        fruits.clear();
        System.out.println("모든 요소 삭제 후: " + fruits);
        System.out.println("Set이 비어있나요? " + fruits.isEmpty());
    }
} 