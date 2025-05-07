package chapter9.examples.ex2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Collectors 사용 예제
 * 
 * 이 예제에서는 스트림의 결과를 수집하는 다양한 방법을 보여줍니다.
 */
public class CollectorsExample {
    
    // 학생 클래스 정의
    static class Student {
        private String name;
        private int age;
        private String grade;
        private int score;
        
        public Student(String name, int age, String grade, int score) {
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.score = score;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getGrade() { return grade; }
        public int getScore() { return score; }
        
        @Override
        public String toString() {
            return name + "(" + age + "세, " + grade + ", " + score + "점)";
        }
    }

    public static void main(String[] args) {
        // 학생 목록 생성
        List<Student> students = Arrays.asList(
            new Student("윤학생", 20, "A", 95),
            new Student("김학생", 22, "B", 83),
            new Student("이학생", 19, "A", 91),
            new Student("박학생", 23, "C", 76),
            new Student("손학생", 21, "B", 88),
            new Student("서학생", 20, "A", 97)
        );
        
        System.out.println("===== 기본 컬렉션으로 수집 =====");
        
        // 1. toList - 리스트로 수집
        List<String> nameList = students.stream()
                                       .map(Student::getName)
                                       .collect(Collectors.toList());
        System.out.println("이름 리스트: " + nameList);
        
        // 2. toSet - 중복 제거된 집합으로 수집
        Set<String> gradeSet = students.stream()
                                     .map(Student::getGrade)
                                     .collect(Collectors.toSet());
        System.out.println("등급 집합: " + gradeSet);
        
        // 3. toMap - 맵으로 수집
        Map<String, Integer> nameScoreMap = students.stream()
                                                  .collect(Collectors.toMap(
                                                      Student::getName, 
                                                      Student::getScore
                                                  ));
        System.out.println("이름-점수 맵: " + nameScoreMap);
        
        System.out.println("\n===== 그룹화와 분할 =====");
        
        // 4. groupingBy - 특정 속성으로 그룹화
        Map<String, List<Student>> byGrade = students.stream()
                                                   .collect(Collectors.groupingBy(Student::getGrade));
        
        System.out.println("등급별 학생 그룹:");
        byGrade.forEach((grade, studentList) -> {
            System.out.println(grade + " 등급: " + studentList);
        });
        
        // 5. partitioningBy - 조건에 따라 두 그룹으로 분할
        Map<Boolean, List<Student>> byScoreOver90 = students.stream()
                                                          .collect(Collectors.partitioningBy(s -> s.getScore() >= 90));
        
        System.out.println("\n90점 이상과 미만으로 분할:");
        System.out.println("90점 이상: " + byScoreOver90.get(true));
        System.out.println("90점 미만: " + byScoreOver90.get(false));
        
        System.out.println("\n===== 통계 수집 =====");
        
        // 6. counting - 요소 개수 계산
        long studentCount = students.stream()
                                   .collect(Collectors.counting());
        System.out.println("총 학생 수: " + studentCount);
        
        // 7. summingInt, averagingInt - 합계와 평균 계산
        int totalScore = students.stream()
                               .collect(Collectors.summingInt(Student::getScore));
        double averageScore = students.stream()
                                    .collect(Collectors.averagingInt(Student::getScore));
        
        System.out.println("점수 합계: " + totalScore);
        System.out.println("점수 평균: " + averageScore);
        
        // 8. summarizingInt - 여러 통계 한번에 계산
        IntSummaryStatistics scoreStats = students.stream()
                                                .collect(Collectors.summarizingInt(Student::getScore));
        
        System.out.println("\n점수 통계:");
        System.out.println("개수: " + scoreStats.getCount());
        System.out.println("합계: " + scoreStats.getSum());
        System.out.println("평균: " + scoreStats.getAverage());
        System.out.println("최소값: " + scoreStats.getMin());
        System.out.println("최대값: " + scoreStats.getMax());
        
        System.out.println("\n===== 문자열 결합 =====");
        
        // 9. joining - 문자열 결합
        String namesCsv = students.stream()
                                .map(Student::getName)
                                .collect(Collectors.joining(", "));
        
        System.out.println("학생 이름 (쉼표 구분): " + namesCsv);
        
        // 구분자, 접두사, 접미사 지정
        String namesFormatted = students.stream()
                                      .map(Student::getName)
                                      .collect(Collectors.joining(", ", "학생 명단: [", "]"));
        
        System.out.println(namesFormatted);
    }
} 