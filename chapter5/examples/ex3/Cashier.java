package chapter5.examples.ex3;

/**
 * 캐셔(수납원) 역할을 정의하는 인터페이스
 */
public interface Cashier {
    // 상수 정의
    double MIN_ORDER_AMOUNT = 1000.0;
    
    // 추상 메소드
    boolean processPayment(Customer customer, Order order, double amount);
    
    void issueReceipt(Order order);
    
    double calculateChange(double paymentAmount, double orderAmount);
    
    // default 메소드
    default double applyDiscount(Order order, Customer customer) {
        double price = order.calculatePrice();
        
        if (customer.isMember()) {
            price = price * (100 - Customer.MEMBERSHIP_DISCOUNT) / 100.0;
            System.out.println("멤버십 할인 " + Customer.MEMBERSHIP_DISCOUNT + "% 적용되었습니다.");
        }
        
        return price;
    }
} 