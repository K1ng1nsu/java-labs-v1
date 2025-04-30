package chapter4.examples.ex6;

/**
 * 엔진 클래스 - 자동차에 포함(has-a)되는 관계
 */
public class Engine {
    // 필드
    private String type;      // 엔진 타입 (가솔린, 디젤, 전기 등)
    private int horsePower;   // 마력
    private boolean running;  // 작동 상태
    
    // 생성자
    public Engine(String type, int horsePower) {
        this.type = type;
        this.horsePower = horsePower;
        this.running = false;
    }
    
    // 엔진 시동 메소드
    public void start() {
        if (!running) {
            running = true;
            System.out.println(type + " 엔진 시동을 걸었습니다. (" + horsePower + "hp)");
        } else {
            System.out.println("이미 엔진이 가동 중입니다.");
        }
    }
    
    // 엔진 정지 메소드
    public void stop() {
        if (running) {
            running = false;
            System.out.println(type + " 엔진을 정지했습니다.");
        } else {
            System.out.println("이미 엔진이 정지해 있습니다.");
        }
    }
    
    // 상태 확인 메소드
    public boolean isRunning() {
        return running;
    }
    
    // 엔진 정보 출력 메소드
    public void displayInfo() {
        System.out.println("엔진 타입: " + type);
        System.out.println("마력: " + horsePower + "hp");
        System.out.println("상태: " + (running ? "가동 중" : "정지"));
    }
    
    // Getter, Setter 메소드
    public String getType() {
        return type;
    }
    
    public int getHorsePower() {
        return horsePower;
    }
} 