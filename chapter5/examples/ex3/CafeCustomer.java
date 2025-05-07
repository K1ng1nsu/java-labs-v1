package chapter5.examples.ex3;

/**
 * Customer 인터페이스를 구현한 카페 손님 클래스
 */
public class CafeCustomer implements Customer {
    // 필드
    private String name;
    private String paymentMethod;
    private boolean membershipStatus;
    
    /**
     * 생성자
     */
    public CafeCustomer(String name, String paymentMethod, boolean membershipStatus) {
        this.name = name;
        this.paymentMethod = paymentMethod;
        this.membershipStatus = membershipStatus;
    }
    
    @Override
    public void placeOrder(Order order) {
        System.out.println(name + "님이 " + order.getCoffeeType() + " " + 
                           order.getQuantity() + "잔을 주문했습니다.");
    }
    
    @Override
    public boolean makePayment(double amount) {
        System.out.println(name + "님이 " + paymentMethod + "로 " + amount + "원을 결제했습니다.");
        return true; // 결제 성공 가정
    }
    
    @Override
    public String getCustomerName() {
        return name;
    }
    
    @Override
    public boolean isMember() {
        return membershipStatus;
    }
    
    /**
     * 클래스 고유 메소드
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void joinMembership() {
        if (!membershipStatus) {
            membershipStatus = true;
            System.out.println(name + "님이 멤버십에 가입했습니다!");
        } else {
            System.out.println(name + "님은 이미 멤버십 회원입니다.");
        }
    }
} 