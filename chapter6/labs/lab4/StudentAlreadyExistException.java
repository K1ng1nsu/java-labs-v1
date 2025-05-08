package chapter6.labs.lab4;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException() {
        super("해당 ID를 가진 학생이 이미 존재합니다.");
    }
}
