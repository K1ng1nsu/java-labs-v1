package chapter6.examples.ex4;

/**
 * 사용자 정의 예외 클래스
 * 
 * 이 클래스는 사용자 정의 예외를 만드는 방법을 보여줍니다.
 * Exception 클래스를 상속받아 커스텀 예외를 정의합니다.
 */
public class CustomException extends Exception {
    // 사용자 정의 상태 코드
    private int errorCode;
    
    /**
     * 기본 생성자
     */
    public CustomException() {
        super("사용자 정의 예외가 발생했습니다.");
        this.errorCode = 0;
    }
    
    /**
     * 메시지를 받는 생성자
     * @param message 예외 메시지
     */
    public CustomException(String message) {
        super(message);
        this.errorCode = 0;
    }
    
    /**
     * 메시지와 에러 코드를 받는 생성자
     * @param message 예외 메시지
     * @param errorCode 에러 코드
     */
    public CustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    /**
     * 메시지와 원인이 되는 예외를 받는 생성자
     * @param message 예외 메시지
     * @param cause 원인이 되는 예외
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = 0;
    }
    
    /**
     * 모든 매개변수를 받는 생성자
     * @param message 예외 메시지
     * @param cause 원인이 되는 예외
     * @param errorCode 에러 코드
     */
    public CustomException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    /**
     * 에러 코드를 반환하는 메소드
     * @return 에러 코드
     */
    public int getErrorCode() {
        return errorCode;
    }
} 