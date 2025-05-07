package chapter5.examples.ex3;

/**
 * Barista 인터페이스를 구현한 카페 바리스타 클래스
 */
public class CafeBarista implements Barista {
    // 필드
    private String name;
    private int experience; // 경력(년)
    
    /**
     * 생성자
     */
    public CafeBarista(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }
    
    @Override
    public void prepareCoffee(Order order) {
        if (!"결제완료".equals(order.getOrderStatus())) {
            System.out.println("아직 결제가 완료되지 않은 주문입니다.");
            return;
        }
        
        // 재료 확인
        if (!checkIngredients(order.getCoffeeType())) {
            System.out.println("재료가 부족하여 주문을 처리할 수 없습니다.");
            return;
        }
        
        // 커피 제조 과정
        System.out.println(name + " 바리스타가 " + order.getCoffeeType() + " " + 
                          order.getQuantity() + "잔을 준비중입니다...");
        
        // 제조 과정 시뮬레이션
        System.out.println("1. 에스프레소 추출 중...");
        System.out.println("2. " + (order.getCoffeeType().contains("라떼") || 
                                   order.getCoffeeType().equals("카푸치노") ? "우유 스팀 중..." : "물 추가 중..."));
        if (order.getCoffeeType().equals("바닐라라떼")) {
            System.out.println("3. 바닐라 시럽 추가 중...");
        }
        System.out.println("4. 완성 및 품질 확인 중...");
        
        // 주문 상태 업데이트
        order.setOrderStatus("준비완료");
    }
    
    @Override
    public void serveCoffee(Order order, Customer customer) {
        if (!"준비완료".equals(order.getOrderStatus())) {
            System.out.println("아직 음료가 준비되지 않았습니다.");
            return;
        }
        
        // 손님 인사
        greetCustomer(customer);
        
        // 주문 제공
        System.out.println(name + " 바리스타가 " + order.getCoffeeType() + " " + 
                          order.getQuantity() + "잔을 제공했습니다.");
        
        // 주문 상태 업데이트
        order.setOrderStatus("제공완료");
    }
    
    @Override
    public boolean checkIngredients(String coffeeType) {
        // 실제로는 재고 시스템과 연동되어야 하지만, 예제에서는 항상 재료가 있다고 가정
        System.out.println(coffeeType + " 제조에 필요한 재료를 확인했습니다.");
        return true;
    }
    
    /**
     * 클래스 고유 메소드
     */
    public String getName() {
        return name;
    }
    
    public int getExperience() {
        return experience;
    }
    
    public void createLatte_Art(String pattern) {
        if (experience >= 2) {
            System.out.println(name + " 바리스타가 '" + pattern + "' 패턴으로 라떼아트를 만들었습니다.");
        } else {
            System.out.println(name + " 바리스타는 아직 라떼아트 기술이 부족합니다.");
        }
    }
} 