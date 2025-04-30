package chapter4.examples.ex6;

/**
 * 자동차 클래스 - 엔진을 포함(has-a)하는 관계
 */
public class Car {
    // 필드
    private String model;     // 모델명
    private String color;     // 색상
    private Engine engine;    // 엔진 (포함 관계: Car has-a Engine)
    private int speed;        // 현재 속도
    
    // 생성자
    public Car(String model, String color, String engineType, int horsePower) {
        this.model = model;
        this.color = color;
        // 자동차 생성 시 엔진 객체도 함께 생성 (has-a 관계)
        this.engine = new Engine(engineType, horsePower);
        this.speed = 0;
    }
    
    // 시동 걸기 메소드
    public void start() {
        System.out.println(model + " 시동을 겁니다.");
        // Car 객체가 Engine 객체의 메소드 호출
        engine.start();
    }
    
    // 시동 끄기 메소드
    public void stop() {
        if (speed > 0) {
            System.out.println("먼저 차를 멈춰야 합니다.");
            return;
        }
        
        System.out.println(model + " 시동을 끕니다.");
        engine.stop();
    }
    
    // 가속 메소드
    public void accelerate(int amount) {
        if (!engine.isRunning()) {
            System.out.println("시동이 꺼져 있어 가속할 수 없습니다.");
            return;
        }
        
        speed += amount;
        System.out.println(amount + "km/h 가속했습니다. 현재 속도: " + speed + "km/h");
    }
    
    // 감속 메소드
    public void brake(int amount) {
        if (speed - amount < 0) {
            speed = 0;
        } else {
            speed -= amount;
        }
        
        System.out.println(amount + "km/h 감속했습니다. 현재 속도: " + speed + "km/h");
    }
    
    // 자동차 정보 출력 메소드
    public void displayInfo() {
        System.out.println("\n===== 자동차 정보 =====");
        System.out.println("모델: " + model);
        System.out.println("색상: " + color);
        System.out.println("현재 속도: " + speed + "km/h");
        System.out.println("------ 엔진 정보 ------");
        engine.displayInfo();
        System.out.println("=====================");
    }
    
    // Getter 메소드들
    public String getModel() {
        return model;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public Engine getEngine() {
        return engine;
    }
} 