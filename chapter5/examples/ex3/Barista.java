package chapter5.examples.ex3;

/**
 * 바리스타 역할을 정의하는 인터페이스
 */
public interface Barista {
    // 상수 정의
    int PREPARATION_TIME = 3; // 기본 제조 시간(분)
    
    // 추상 메소드
    void prepareCoffee(Order order);
    
    void serveCoffee(Order order, Customer customer);
    
    boolean checkIngredients(String coffeeType);
    
    // default 메소드
    default void greetCustomer(Customer customer) {
        System.out.println(customer.getCustomerName() + "님, 주문하신 음료 나왔습니다!");
    }
    
    // static 메소드
    static void coffeePreparationTips() {
        System.out.println("===== 커피 제조 팁 =====");
        System.out.println("1. 에스프레소는 25-30초간 추출");
        System.out.println("2. 우유 스팀은 65-70도가 적당");
        System.out.println("3. 라떼아트는 우유와 에스프레소의 비율이 중요");
    }
} 