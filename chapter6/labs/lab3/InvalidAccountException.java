package chapter6.labs.lab3;

/**
 * 유효하지 않은 계좌 예외 클래스
 * 
 * 계좌번호가 유효하지 않을 때 발생하는 사용자 정의 예외입니다.
 */
public class InvalidAccountException extends Exception {
    private String accountNumber;
    
    /**
     * 생성자
     * @param message 예외 메시지
     * @param accountNumber 유효하지 않은 계좌번호
     */
    public InvalidAccountException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }
    
    /**
     * 유효하지 않은 계좌번호 반환
     * @return 유효하지 않은 계좌번호
     */
    public String getAccountNumber() {
        return accountNumber;
    }
} 