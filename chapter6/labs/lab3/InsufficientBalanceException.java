package chapter6.labs.lab3;

/**
 * 잔액 부족 예외 클래스
 * 
 * 계좌의 잔액이 요청된 금액보다 적을 때 발생하는 사용자 정의 예외입니다.
 */
public class InsufficientBalanceException extends Exception {
    private double requestedAmount;
    private double availableBalance;
    
    /**
     * 생성자
     * @param message 예외 메시지
     * @param requestedAmount 요청된 금액
     * @param availableBalance 사용 가능한 잔액
     */
    public InsufficientBalanceException(String message, double requestedAmount, double availableBalance) {
        super(message);
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
    }
    
    /**
     * 요청된 금액 반환
     * @return 요청된 금액
     */
    public double getRequestedAmount() {
        return requestedAmount;
    }
    
    /**
     * 사용 가능한 잔액 반환
     * @return 사용 가능한 잔액
     */
    public double getAvailableBalance() {
        return availableBalance;
    }
    
    /**
     * 부족한 금액 계산
     * @return 부족한 금액
     */
    public double getDeficit() {
        return requestedAmount - availableBalance;
    }
} 