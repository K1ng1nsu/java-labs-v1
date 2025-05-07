package chapter5.examples.ex3;

/**
 * Order 인터페이스를 구현한 커피 주문 클래스
 */
public class CoffeeOrder implements Order {
    // 필드
    private String coffeeType;
    private int quantity;
    private String status;
    
    // 가격표
    private static final double AMERICANO_PRICE = 4500.0;
    private static final double LATTE_PRICE = 5000.0;
    private static final double CAPPUCCINO_PRICE = 5500.0;
    private static final double VANILLA_LATTE_PRICE = 5800.0;
    
    /**
     * 생성자
     */
    public CoffeeOrder(String coffeeType, int quantity) {
        this.coffeeType = coffeeType;
        this.quantity = quantity;
        this.status = "주문됨";
    }
    
    @Override
    public String getCoffeeType() {
        return coffeeType;
    }
    
    @Override
    public int getQuantity() {
        return quantity;
    }
    
    @Override
    public String getOrderStatus() {
        return status;
    }
    
    @Override
    public void setOrderStatus(String status) {
        this.status = status;
    }
    
    @Override
    public double calculatePrice() {
        double unitPrice = 0.0;
        
        switch (coffeeType.toLowerCase()) {
            case "아메리카노":
                unitPrice = AMERICANO_PRICE;
                break;
            case "라떼":
            case "카페라떼":
                unitPrice = LATTE_PRICE;
                break;
            case "카푸치노":
                unitPrice = CAPPUCCINO_PRICE;
                break;
            case "바닐라라떼":
                unitPrice = VANILLA_LATTE_PRICE;
                break;
            default:
                unitPrice = AMERICANO_PRICE; // 기본값
        }
        
        return unitPrice * quantity;
    }
} 