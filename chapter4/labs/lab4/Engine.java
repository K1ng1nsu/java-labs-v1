package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private String type;
    private String horsePower;
    private boolean isRunning;

    
    
    // TODO: 생성자를 정의하세요.

    public Engine(String type, String horsePower) {
        this.type = type;
        this.horsePower = horsePower;
    }


    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void start(){
        isRunning = true;
    }
    
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stop(){
        isRunning = false;
    }
    
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public boolean isRunning(){
        return isRunning;
    }
    
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", horsePower='" + horsePower + '\'' +
                ", isRunning=" + isRunning +
                '}';
    }


    // TODO: 필요한 getter/setter 메소드를 정의하세요.


    public String getType() {
        return type;
    }

    public String getHorsePower() {
        return horsePower;
    }

}