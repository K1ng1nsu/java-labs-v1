package chapter5.examples.ex3;

/**
 * 손님 역할을 정의하는 인터페이스
 */
public interface Customer {
    // 상수 정의
    int MEMBERSHIP_DISCOUNT = 10; // 멤버십 할인율(%)
    
    // 추상 메소드
    void placeOrder(Order order);
    
    boolean makePayment(double amount);
    
    String getCustomerName();
    
    // default 메소드
    default boolean isMember() {
        return false; // 기본적으로는 멤버가 아님
    }
    
    // static 메소드
    static void showCustomerBenefits() {
        System.out.println("===== 손님 혜택 안내 =====");
        System.out.println("1. 멤버십 가입 시 " + MEMBERSHIP_DISCOUNT + "% 할인");
        System.out.println("2. 스탬프 10개 모으면 무료 음료 제공");
        System.out.println("3. 생일자 무료 케이크 조각 제공");
    }
} 