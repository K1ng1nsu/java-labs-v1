package chapter3.labs.lab5;

/**
 * 학생 성적 등급을 나타내는 열거형
 */
public enum Grade {
    A("탁월함", 90, 100),
    B("우수함", 80, 89),
    C("양호함", 70, 79),
    D("보통", 60, 69),
    F("노력 필요", 0, 59);
    
    private final String description; // 등급 설명
    private final int minScore; // 최소 점수
    private final int maxScore; // 최대 점수
    
    // 생성자
    Grade(String description, int minScore, int maxScore) {
        this.description = description;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }
    
    // 점수에 해당하는 등급 반환
    public static Grade getGradeFromScore(int score) {
        for (Grade grade : Grade.values()) {
            if (score >= grade.minScore && score <= grade.maxScore) {
                return grade;
            }
        }
        return F; // 기본값 (오류 시)
    }
    
    // Getter 메소드
    public String getDescription() {
        return description;
    }
    
    public int getMinScore() {
        return minScore;
    }
    
    public int getMaxScore() {
        return maxScore;
    }
    
    @Override
    public String toString() {
        return this.name() + " (" + description + ", " + minScore + "-" + maxScore + ")";
    }
} 