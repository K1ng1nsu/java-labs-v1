package chapter6.labs.lab4;

public class StudentCanNotFoundException extends RuntimeException {
    public StudentCanNotFoundException() {
        super("해당 학생을 찾을 수 없습니다.");
    }
}
