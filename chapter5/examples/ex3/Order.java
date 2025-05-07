package chapter5.examples.ex3;

/**
 * 주문 정보를 정의하는 인터페이스
 */
public interface Order {
    // 상수 정의
    String SHOP_NAME = "자바 카페";
    
    // 추상 메소드
    String getCoffeeType();
    
    int getQuantity();
    
    String getOrderStatus();
    
    void setOrderStatus(String status);
    
    double calculatePrice();
    
    // default 메소드
    default void displayOrderInfo() {
        System.out.println("===== 주문 정보 =====");
        System.out.println("주문 상태: " + getOrderStatus());
        System.out.println("주문 커피: " + getCoffeeType() + " " + getQuantity() + "잔");
        System.out.println("주문 금액: " + calculatePrice() + "원");
        System.out.println("주문 장소: " + SHOP_NAME);
    }
    
    // static 메소드
    static void showMenu() {
        System.out.println("===== " + SHOP_NAME + " 메뉴 =====");
        System.out.println("1. 아메리카노 - 4,500원");
        System.out.println("2. 카페라떼 - 5,000원");
        System.out.println("3. 카푸치노 - 5,500원");
        System.out.println("4. 바닐라라떼 - 5,800원");
    }
} 