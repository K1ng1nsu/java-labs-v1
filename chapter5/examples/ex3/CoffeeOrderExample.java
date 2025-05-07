package chapter5.examples.ex3;

/**
 * 역할 기반 커피 주문 인터페이스 예제를 실행하는 메인 클래스
 */
public class CoffeeOrderExample {
    public static void main(String[] args) {
        System.out.println("===== 자바 인터페이스 활용 예제: 커피숍 역할 모델 =====");
        
        // 커피숍 메뉴 표시 (Order 인터페이스의 static 메소드)
        Order.showMenu();
        
        // 손님 혜택 정보 표시 (Customer 인터페이스의 static 메소드)
        Customer.showCustomerBenefits();
        
        // 바리스타 커피 제조 팁 표시 (Barista 인터페이스의 static 메소드)
        Barista.coffeePreparationTips();
        
        System.out.println("\n===== 커피 주문 시나리오 시작 =====");
        
        // 1. 손님 객체 생성
        CafeCustomer customer = new CafeCustomer("윤손님", "카드", false);
        
        // 2. 주문 생성
        CoffeeOrder order = new CoffeeOrder("카페라떼", 2);
        
        // 3. 손님이 주문
        customer.placeOrder(order);
        
        // 4. 주문 정보 표시 (Order 인터페이스의 default 메소드)
        order.displayOrderInfo();
        
        // 5. 캐셔 객체 생성
        CafeCashier cashier = new CafeCashier("김캐셔");
        
        // 6. 결제 처리
        boolean paymentResult = cashier.processPayment(customer, order, 12000);
        
        if (paymentResult) {
            // 영수증 발행
            cashier.issueReceipt(order);
            
            // 7. 바리스타 객체 생성
            CafeBarista barista = new CafeBarista("한바리", 3);
            
            // 8. 커피 준비
            barista.prepareCoffee(order);
            
            // 9. 커피 서빙
            barista.serveCoffee(order, customer);
            
            // 10. 라떼아트 (바리스타 클래스 고유 메소드)
            if (order.getCoffeeType().contains("라떼")) {
                barista.createLatte_Art("하트");
            }
        }
        
        // 멤버십 가입 (고객 클래스 고유 메소드)
        System.out.println("\n고객이 멤버십에 가입합니다:");
        customer.joinMembership();
        
        // 새 주문 생성
        System.out.println("\n멤버십 할인이 적용된 두번째 주문:");
        CoffeeOrder secondOrder = new CoffeeOrder("바닐라라떼", 1);
        customer.placeOrder(secondOrder);
        
        // 멤버십 할인 적용된 결제 처리
        cashier.processPayment(customer, secondOrder, 6000);
        cashier.issueReceipt(secondOrder);
        
        // 일일 판매 요약 (캐셔 클래스 고유 메소드)
        cashier.printDailySummary();
    }
} 