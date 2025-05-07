package chapter6.labs.lab4;

import java.util.Scanner;

/**
 * Lab 4: 디버깅 실습
 * 
 * 학생 성적 관리 프로그램의 테스트 클래스입니다.
 * StudentGradeManager 클래스의 오류를 디버깅하고 수정하세요.
 */
public class StudentGradeManagerTest {
    public static void main(String[] args) {
        System.out.println("Lab 4: 디버깅 실습");
        System.out.println("학생 성적 관리 프로그램을 테스트합니다.");
        
        // 학생 성적 관리자 객체 생성
        StudentGradeManager manager = new StudentGradeManager();
        
        // 테스트 데이터 추가
        addTestData(manager);
        
        // 테스트 실행
        runTests(manager);
    }
    
    /**
     * 테스트 데이터 추가 메소드
     */
    private static void addTestData(StudentGradeManager manager) {
        try {
            // 학생 추가 테스트
            manager.addStudent(1, "윤학생", new int[]{85, 90, 75});
            manager.addStudent(2, "이학생", new int[]{70, 88, 92});
            manager.addStudent(3, "김학생", new int[]{95, 92, 98});
            
            // 중복 ID 테스트
            manager.addStudent(1, "중복학생", new int[]{50, 60, 70});
            
            System.out.println("\n총 학생 수: " + manager.getStudentCount());
        } catch (Exception e) {
            System.out.println("테스트 데이터 추가 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 테스트 실행 메소드
     */
    private static void runTests(StudentGradeManager manager) {
        try {
            // 테스트 1: 모든 학생 정보 출력
            System.out.println("\n[테스트 1] 모든 학생 정보 출력");
            manager.printAllStudents();
            
            // 테스트 2: 학생 정보 조회
            System.out.println("\n[테스트 2] 학생 정보 조회");
            testStudentLookup(manager, 1);  // 있는 학생
            testStudentLookup(manager, 99); // 없는 학생
            
            // 테스트 3: 평균 성적 계산
            System.out.println("\n[테스트 3] 평균 성적 계산");
            testAverageCalculation(manager, 2);
            
        } catch (Exception e) {
            System.out.println("테스트 실행 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 학생 정보 조회 테스트
     */
    private static void testStudentLookup(StudentGradeManager manager, int id) {
        System.out.println("학생 ID " + id + " 조회:");
        StudentGradeManager.Student student = manager.getStudent(id);
        
        if (student != null) {
            System.out.println("조회 결과: " + student);
        } else {
            System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
        }
    }
    
    /**
     * 평균 성적 계산 테스트
     */
    private static void testAverageCalculation(StudentGradeManager manager, int id) {
        System.out.println("학생 ID " + id + "의 평균 성적:");
        double average = manager.calculateAverageScore(id);
        
        if (average == -1) {
            System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
        } else {
            System.out.println("평균 점수: " + average);
            System.out.println("성적 등급: " + manager.calculateGrade(average));
        }
    }
} 