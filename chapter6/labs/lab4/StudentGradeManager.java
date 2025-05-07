package chapter6.labs.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Lab 4: 디버깅 실습
 * 
 * 학생 성적 관리 프로그램입니다.
 * 이 프로그램에는 논리적 오류와 버그가 포함되어 있습니다.
 * 디버깅 기법을 활용하여 오류를 찾고 수정하세요.
 */
public class StudentGradeManager {
    
    // 학생 목록
    private List<Student> students;
    
    /**
     * 생성자
     */
    public StudentGradeManager() {
        students = new ArrayList<>();
    }
    
    /**
     * 학생 추가 메소드
     * @param id 학생 ID
     * @param name 학생 이름
     * @param scores 성적 배열
     */
    public void addStudent(int id, String name, int[] scores) {
        // TODO: 디버깅 - 다음 코드에 버그가 있습니다.
        // 동일한 ID를 가진 학생이 이미 있는지 확인하지 않고 있습니다.
        
        Student student = new Student(id, name, scores);
        students.add(student);
        System.out.println("학생을 추가했습니다: " + student);
    }
    
    /**
     * 학생 성적 업데이트 메소드
     * @param id 학생 ID
     * @param newScores 새 성적 배열
     * @return 업데이트 성공 여부
     */
    public boolean updateStudentScores(int id, int[] newScores) {
        // TODO: 디버깅 - 다음 코드에 버그가 있습니다.
        // 1. 학생을 찾는 로직에 문제가 있습니다.
        // 2. 반환값 처리에 문제가 있습니다.
        
        for (int i = 0; i <= students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.get(i).setScores(newScores);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 평균 성적 계산 메소드
     * @param id 학생 ID
     * @return 평균 성적 또는 학생을 찾지 못한 경우 -1
     */
    public double calculateAverageScore(int id) {
        // TODO: 디버깅 - 다음 코드에 버그가 있습니다.
        // 평균 계산 로직에 문제가 있습니다(정수 나눗셈 문제).
        
        for (Student student : students) {
            if (student.getId() == id) {
                int[] scores = student.getScores();
                int sum = 0;
                
                for (int score : scores) {
                    sum += score;
                }
                
                // 평균 계산
                return sum / scores.length;
            }
        }
        
        return -1;  // 학생을 찾지 못함
    }
    
    /**
     * 상위 성적 학생 찾기 메소드
     * @param threshold 기준 점수
     * @return 기준 점수 이상의 평균을 가진 학생 목록
     */
    public List<Student> findTopStudents(double threshold) {
        // TODO: 디버깅 - 다음 코드에 버그가 있습니다.
        // 1. 리스트 수정 방법에 문제가 있습니다.
        // 2. 비교 로직에 문제가 있습니다.
        
        List<Student> result = new ArrayList<>(students);  // 원본 리스트를 복사
        
        for (Student student : result) {
            double average = calculateAverageScore(student.getId());
            if (average <= threshold) {  // 의도와 다른 비교 연산자
                result.remove(student);  // ConcurrentModificationException 발생 가능
            }
        }
        
        return result;
    }
    
    /**
     * 성적 등급 계산 메소드
     * @param score 점수
     * @return 등급 (A, B, C, D, F)
     */
    public char calculateGrade(double score) {
        if (score > 90) {
            return 'A';
        } else if (score > 80) {
            return 'B';
        } else if (score > 70) {
            return 'C';
        } else if (score > 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    /**
     * 학생 목록 출력 메소드
     */
    public void printAllStudents() {
        for (Student student : students) {
            System.out.println("학생 정보: " + student);
            double average = calculateAverageScore(student.getId());
            char grade = calculateGrade(average);
            System.out.println("평균 점수: " + average + ", 등급: " + grade);
        }
    }
    
    /**
     * 학생 정보 조회 메소드
     * @param id 학생 ID
     * @return 학생 객체 또는 찾지 못한 경우 null
     */
    public Student getStudent(int id) {
        // TODO: 디버깅 - 다음 코드에 버그가 있습니다.
        // 비교 조건에 문제가 있습니다.
        
        for (Student student : students) {
            if (student.getId() != id) {  // 잘못된 비교 조건
                return student;
            }
        }
        
        return null;
    }
    
    /**
     * 학생 수 반환 메소드
     * @return 학생 수
     */
    public int getStudentCount() {
        return students.size();
    }
    
    /**
     * 내부 Student 클래스
     */
    public static class Student {
        private int id;
        private String name;
        private int[] scores;
        
        /**
         * 생성자
         * @param id 학생 ID
         * @param name 학생 이름
         * @param scores 성적 배열
         */
        public Student(int id, String name, int[] scores) {
            this.id = id;
            this.name = name;
            this.scores = scores;
        }
        
        /**
         * ID 반환
         * @return 학생 ID
         */
        public int getId() {
            return id;
        }
        
        /**
         * 이름 반환
         * @return 학생 이름
         */
        public String getName() {
            return name;
        }
        
        /**
         * 성적 배열 반환
         * @return 성적 배열
         */
        public int[] getScores() {
            return scores;
        }
        
        /**
         * 성적 배열 설정
         * @param scores 새 성적 배열
         */
        public void setScores(int[] scores) {
            this.scores = scores;
        }
        
        /**
         * 학생 정보 문자열 반환
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ID=").append(id)
              .append(", 이름='").append(name).append("'")
              .append(", 성적=[");
            
            if (scores != null) {
                for (int i = 0; i < scores.length; i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(scores[i]);
                }
            }
            
            sb.append("]");
            return sb.toString();
        }
    }
} 