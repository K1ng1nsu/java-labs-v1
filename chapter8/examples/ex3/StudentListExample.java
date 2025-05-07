package chapter8.examples.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Ex 3: 학생 목록 관리 예제
 * 
 * Student 객체를 ArrayList에 저장하고 다양한 방식으로 처리하는 예제입니다.
 */
public class StudentListExample {
    public static void main(String[] args) {
        // 학생 목록을 저장할 ArrayList 생성
        List<Student> students = new ArrayList<>();
        
        // 학생 추가
        students.add(new Student(1003, "김학생", 22, 3.8));
        students.add(new Student(1001, "이학생", 20, 4.2));
        students.add(new Student(1002, "박학생", 21, 3.5));
        students.add(new Student(1004, "정학생", 23, 4.0));
        students.add(new Student(1005, "황학생", 19, 3.7));
        
        // 원본 학생 목록 출력
        System.out.println("=== 원본 학생 목록 ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        // ID로 기본 정렬 (Comparable 인터페이스 사용)
        Collections.sort(students);
        System.out.println("\n=== ID 기준 정렬 결과 ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        // 이름으로 정렬 (Comparator 사용)
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        
        System.out.println("\n=== 이름 기준 정렬 결과 ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        // 나이 기준 정렬 (람다식 사용)
        Collections.sort(students, (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        
        System.out.println("\n=== 나이 기준 정렬 결과 ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        // GPA 기준 역순 정렬 (Comparator.comparing 사용)
        Collections.sort(students, Comparator.comparing(Student::getGpa).reversed());
        
        System.out.println("\n=== GPA 기준 역순 정렬 결과 ===");
        for (Student student : students) {
            System.out.println(student);
        }
        
        // 특정 학생 찾기
        System.out.println("\n=== 학생 검색 ===");
        Student searchStudent = new Student(1003, null, 0, 0);
        int index = students.indexOf(searchStudent);
        
        if (index != -1) {
            System.out.println("찾은 학생: " + students.get(index));
        } else {
            System.out.println("해당 ID의 학생이 없습니다.");
        }
        
        // 조건에 맞는 학생 필터링 (Java 8 스트림 API 사용)
        System.out.println("\n=== 조건 필터링 (GPA 4.0 이상) ===");
        students.stream()
                .filter(s -> s.getGpa() >= 4.0)
                .forEach(System.out::println);
        
        // 학생 정보 수정
        if (index != -1) {
            Student student = students.get(index);
            student.setGpa(3.9);
            System.out.println("\n=== 수정된 학생 정보 ===");
            System.out.println(student);
        }
        
        // 학생 삭제
        System.out.println("\n=== 학생 삭제 후 ===");
        students.remove(searchStudent);
        for (Student student : students) {
            System.out.println(student);
        }
    }
} 