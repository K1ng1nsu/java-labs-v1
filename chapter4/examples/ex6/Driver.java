package chapter4.examples.ex6;

/**
 * 운전자 클래스 - 자동차를 사용(uses-a)하는 관계
 */
public class Driver {
    // 필드
    private String name;        // 이름
    private int licenseYear;    // 운전 경력(연도)
    
    // 생성자
    public Driver(String name, int licenseYear) {
        this.name = name;
        this.licenseYear = licenseYear;
    }
    
    // 자동차 운전 메소드 (uses-a 관계)
    public void drive(Car car) {
        System.out.println("\n" + name + "이(가) " + car.getModel() + "을(를) 운전합니다.");
        car.start();
        car.accelerate(30);
        System.out.println("안전 운전 중...");
        car.accelerate(20);
        car.brake(15);
        car.brake(35);
        car.stop();
    }
    
    // 자동차 정보 확인 메소드
    public void checkCar(Car car) {
        System.out.println("\n" + name + "이(가) 차량을 점검합니다.");
        car.displayInfo();
    }
    
    // 운전자 정보 출력 메소드
    public void displayInfo() {
        System.out.println("\n===== 운전자 정보 =====");
        System.out.println("이름: " + name);
        System.out.println("운전 경력: " + licenseYear + "년");
        System.out.println("=====================");
    }
} 