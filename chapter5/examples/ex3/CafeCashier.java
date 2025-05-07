package chapter5.examples.ex3;

/**
 * Cashier 인터페이스를 구현한 카페 캐셔 클래스
 */
public class CafeCashier implements Cashier {
    // 필드
    private String name;
    private int salesCount;
    
    /**
     * 생성자
     */
    public CafeCashier(String name) {
        this.name = name;
        this.salesCount = 0;
    }
    
    @Override
    public boolean processPayment(Customer customer, Order order, double amount) {
        // 할인 적용된 최종 가격 계산
        double finalPrice = applyDiscount(order, customer);
        
        if (amount < finalPrice) {
            System.out.println("결제 금액이 부족합니다. 필요 금액: " + finalPrice + "원");
            return false;
        }
        
        // 결제 처리
        boolean paymentResult = customer.makePayment(amount);
        
        if (paymentResult) {
            // 잔돈 계산
            double change = calculateChange(amount, finalPrice);
            if (change > 0) {
                System.out.println("잔돈 " + change + "원을 반환합니다.");
            }
            
            // 주문 상태 업데이트
            order.setOrderStatus("결제완료");
            salesCount++;
            
            System.out.println(name + " 캐셔가 결제를 처리했습니다.");
        }
        
        return paymentResult;
    }
    
    @Override
    public void issueReceipt(Order order) {
        System.out.println("\n===== 영수증 =====");
        System.out.println("상품: " + order.getCoffeeType() + " x " + order.getQuantity());
        System.out.println("금액: " + order.calculatePrice() + "원");
        System.out.println("===============");
        System.out.println(name + " 캐셔가 영수증을 발행했습니다.");
    }
    
    @Override
    public double calculateChange(double paymentAmount, double orderAmount) {
        return paymentAmount - orderAmount;
    }
    
    /**
     * 클래스 고유 메소드
     */
    public String getName() {
        return name;
    }
    
    public int getSalesCount() {
        return salesCount;
    }
    
    public void printDailySummary() {
        System.out.println("\n===== 일일 판매 요약 =====");
        System.out.println("담당 캐셔: " + name);
        System.out.println("처리한 주문 수: " + salesCount);
        System.out.println("=======================");
    }
} 