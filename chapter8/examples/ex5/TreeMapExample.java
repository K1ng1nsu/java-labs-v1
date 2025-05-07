package chapter8.examples.ex5;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Ex 5: TreeMap 예제
 * 
 * TreeMap의 기본 사용법과 정렬 및 탐색 기능을 보여주는 예제입니다.
 */
public class TreeMapExample {
    public static void main(String[] args) {
        // TreeMap 생성 (자연 정렬 순서)
        TreeMap<String, Integer> scores = new TreeMap<>();
        
        // 요소 추가
        scores.put("홍학생", 95);
        scores.put("김학생", 80);
        scores.put("박학생", 92);
        scores.put("이학생", 88);
        scores.put("정학생", 76);
        
        System.out.println("=== TreeMap 기본 특성 ===");
        System.out.println("성적 목록 (이름 순): " + scores);
        
        // TreeMap의 요소 검색 메소드
        System.out.println("\n=== 요소 검색 ===");
        System.out.println("첫 번째 키: " + scores.firstKey());
        System.out.println("마지막 키: " + scores.lastKey());
        System.out.println("첫 번째 엔트리: " + scores.firstEntry());
        System.out.println("마지막 엔트리: " + scores.lastEntry());
        
        System.out.println("'박학생' 다음 이름: " + scores.higherKey("박학생"));
        System.out.println("'박학생' 이전 이름: " + scores.lowerKey("박학생"));
        
        // 범위 검색
        System.out.println("\n=== 범위 검색 ===");
        SortedMap<String, Integer> subMap1 = scores.subMap("김학생", "이학생");
        System.out.println("'김학생'부터 '이학생' 이전까지: " + subMap1);
        
        NavigableMap<String, Integer> subMap2 = scores.subMap("김학생", true, "이학생", true);
        System.out.println("'김학생'부터 '이학생'까지(포함): " + subMap2);
        
        SortedMap<String, Integer> headMap = scores.headMap("박학생");
        System.out.println("'박학생' 이전 이름들: " + headMap);
        
        SortedMap<String, Integer> tailMap = scores.tailMap("박학생");
        System.out.println("'박학생'부터: " + tailMap);
        
        // 역순 맵
        System.out.println("\n=== 역순 맵 ===");
        NavigableMap<String, Integer> descendingMap = scores.descendingMap();
        System.out.println("역순 정렬: " + descendingMap);
        
        // 사용자 정의 Comparator로 TreeMap 생성
        TreeMap<Student, String> students = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 성적(GPA) 기준 정렬 (높은 점수가 먼저)
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });
        
        // 학생 추가
        students.put(new Student(1001, "홍학생", 3.5), "컴퓨터공학");
        students.put(new Student(1002, "김학생", 4.0), "전자공학");
        students.put(new Student(1003, "박학생", 3.8), "경영학");
        students.put(new Student(1004, "이학생", 3.2), "화학공학");
        students.put(new Student(1005, "정학생", 4.2), "수학");
        
        System.out.println("\n=== 커스텀 정렬 TreeMap (GPA 내림차순) ===");
        for (Map.Entry<Student, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " - 전공: " + entry.getValue());
        }
        
        // floorEntry, ceilingEntry 메소드
        System.out.println("\n=== floorEntry, ceilingEntry 예제 ===");
        Student searchStudent = new Student(0, "", 3.7);
        
        Map.Entry<Student, String> floorEntry = students.floorEntry(searchStudent);
        System.out.println("GPA 3.7 이하 중 가장 높은 학생: " + floorEntry.getKey());
        
        Map.Entry<Student, String> ceilingEntry = students.ceilingEntry(searchStudent);
        System.out.println("GPA 3.7 이상 중 가장 낮은 학생: " + ceilingEntry.getKey());
        
        // pollFirstEntry, pollLastEntry 메소드
        System.out.println("\n=== 요소 추출 ===");
        Map.Entry<Student, String> highest = students.pollFirstEntry();
        Map.Entry<Student, String> lowest = students.pollLastEntry();
        
        System.out.println("성적 최고 학생: " + highest.getKey() + " - 전공: " + highest.getValue());
        System.out.println("성적 최저 학생: " + lowest.getKey() + " - 전공: " + lowest.getValue());
        System.out.println("추출 후 남은 학생 수: " + students.size());
    }
    
    /**
     * 학생 클래스 
     */
    static class Student {
        private int id;
        private String name;
        private double gpa;
        
        public Student(int id, String name, double gpa) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
        }
        
        public int getId() {
            return id;
        }
        
        public String getName() {
            return name;
        }
        
        public double getGpa() {
            return gpa;
        }
        
        @Override
        public String toString() {
            return String.format("%s (학번: %d, GPA: %.1f)", name, id, gpa);
        }
    }
} 