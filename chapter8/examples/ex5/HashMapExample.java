package chapter8.examples.ex5;

import java.util.HashMap;
import java.util.Map;

/**
 * Ex 5: HashMap 예제
 * 
 * HashMap의 기본 사용법과 다양한 메소드를 보여주는 예제입니다.
 */
public class HashMapExample {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> scores = new HashMap<>();
        
        // 요소 추가
        System.out.println("=== 요소 추가 ===");
        scores.put("홍학생", 95);
        scores.put("김학생", 80);
        scores.put("박학생", 92);
        scores.put("이학생", 88);
        scores.put("정학생", 76);
        
        System.out.println("성적 목록: " + scores);
        
        // 요소 접근
        System.out.println("\n=== 요소 접근 ===");
        int hongScore = scores.get("홍학생");
        System.out.println("홍학생의 점수: " + hongScore);
        
        // 존재하지 않는 키 접근 (기본값 사용)
        int unknownScore = scores.getOrDefault("알 수 없음", -1);
        System.out.println("알 수 없는 학생의 점수: " + unknownScore);
        
        // 요소 존재 여부 확인
        System.out.println("\n=== 요소 존재 여부 확인 ===");
        boolean containsKim = scores.containsKey("김학생");
        System.out.println("김학생 있나요? " + containsKim);
        
        boolean contains90 = scores.containsValue(90);
        System.out.println("90점이 있나요? " + contains90);
        
        // 요소 수정
        System.out.println("\n=== 요소 수정 ===");
        scores.put("김학생", 85); // 기존 값 덮어쓰기
        System.out.println("김학생 점수 수정 후: " + scores.get("김학생"));
        
        // putIfAbsent 메소드: 키가 없을 때만 추가
        scores.putIfAbsent("홍학생", 100); // 이미 있으므로 변경 안됨
        scores.putIfAbsent("최학생", 90); // 없었으므로 추가됨
        System.out.println("putIfAbsent 후 성적 목록: " + scores);
        
        // 요소 삭제
        System.out.println("\n=== 요소 삭제 ===");
        scores.remove("이학생");
        System.out.println("이학생 삭제 후 성적 목록: " + scores);
        
        // 특정 키와 값이 모두 일치할 때만 삭제
        boolean removed = scores.remove("정학생", 80); // 값이 일치하지 않으므로 삭제 안됨
        System.out.println("정학생(80점) 삭제 성공? " + removed);
        
        removed = scores.remove("정학생", 76); // 키와 값이 모두 일치
        System.out.println("정학생(76점) 삭제 성공? " + removed);
        
        // 요소 일괄 변경
        System.out.println("\n=== 요소 일괄 변경 ===");
        scores.replaceAll((name, score) -> score + 5); // 모든 점수에 5점 추가
        System.out.println("모든 점수 5점 추가 후: " + scores);
        
        // 요소 탐색 방법
        System.out.println("\n=== 요소 탐색 방법 ===");
        
        // 1. keySet()을 이용한 탐색
        System.out.println("1. keySet() 사용:");
        for (String name : scores.keySet()) {
            System.out.println("  " + name + ": " + scores.get(name));
        }
        
        // 2. entrySet()을 이용한 탐색
        System.out.println("\n2. entrySet() 사용:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
        // 3. forEach() 메소드 사용 (Java 8)
        System.out.println("\n3. forEach() 메소드 사용:");
        scores.forEach((name, score) -> System.out.println("  " + name + ": " + score));
        
        // Map.Entry의 정적 메소드를 이용한 맵 생성 (Java 9 이상)
        /*
        Map<String, Integer> newScores = Map.of(
            "홍학생", 90,
            "김학생", 85,
            "박학생", 95
        );
        System.out.println("\nMap.of()로 생성한 맵: " + newScores);
        */
        
        // compute 메소드 : 값 계산해서 업데이트
        System.out.println("\n=== compute 메소드 ===");
        scores.compute("홍학생", (key, value) -> value - 10); // 홍학생 점수 10점 감점
        System.out.println("홍학생 점수 계산 후: " + scores.get("홍학생"));
        
        // 모든 요소 삭제
        System.out.println("\n=== 맵 비우기 ===");
        scores.clear();
        System.out.println("clear() 후 크기: " + scores.size());
        System.out.println("맵이 비어있나요? " + scores.isEmpty());
    }
} 