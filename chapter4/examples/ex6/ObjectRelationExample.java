package chapter4.examples.ex6;

/**
 * 객체 간 관계 예제 - 메인 클래스
 */
public class ObjectRelationExample {
    public static void main(String[] args) {
        System.out.println("===== 객체 간 관계 예제 =====");
        
        // 자동차 객체 생성 (자동차는 엔진을 포함함 - has-a 관계)
        Car car1 = new Car("Sonata", "Black", "Gasoline", 180);
        Car car2 = new Car("Tesla Model 3", "White", "Electric", 330);
        
        // 운전자 객체 생성
        Driver driver1 = new Driver("John", 5);
        Driver driver2 = new Driver("Emily", 10);
        
        // 객체 정보 출력
        driver1.displayInfo();
        driver2.displayInfo();
        
        // 운전자가 자동차 점검 (사용 관계 - uses-a)
        driver1.checkCar(car1);
        driver2.checkCar(car2);
        
        // 운전자가 자동차 운전 (사용 관계 - uses-a)
        driver1.drive(car1);
        driver2.drive(car2);
        
        System.out.println("\n===== 다양한 객체 관계 =====");
        
        // 직접 엔진 객체 생성 
        Engine specialEngine = new Engine("Hybrid", 220);
        
        // 생성한 엔진 정보 출력
        System.out.println("\n직접 생성한 엔진 정보:");
        specialEngine.displayInfo();
        
        // 일반적인 사용 방식과 차이점 확인
        System.out.println("\n--- 일반적인 사용 방식 ---");
        // 자동차 생성 - 내부적으로 엔진 포함
        Car normalCar = new Car("Grandeur", "Gray", "Gasoline", 240);
        normalCar.displayInfo();
        normalCar.start();
        
        System.out.println("\n--- 구성(Composition) 관계 예시 ---");
        // 자동차 엔진 정보 접근
        Engine carEngine = normalCar.getEngine();
        System.out.println("자동차에 포함된 엔진 타입: " + carEngine.getType());
        System.out.println("자동차에 포함된 엔진 마력: " + carEngine.getHorsePower() + "hp");
        
        System.out.println("\n--- 사용(Uses) 관계 예시 ---");
        // 다른 운전자가 같은 차를 운전하는 경우
        Driver tempDriver = new Driver("David", 3);
        tempDriver.drive(normalCar);
    }
} 