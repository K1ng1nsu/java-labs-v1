package chapter7.examples.ex1;

/**
 * System 클래스의 주요 기능을 보여주는 예제
 */
public class SystemClassExample {
    public static void main(String[] args) {
        // 시스템 속성 출력
        System.out.println("=== 주요 시스템 속성 ===");
        System.out.println("운영체제: " + System.getProperty("os.name"));
        System.out.println("자바 버전: " + System.getProperty("java.version"));
        System.out.println("사용자 홈 디렉토리: " + System.getProperty("user.home"));
        System.out.println("사용자 작업 디렉토리: " + System.getProperty("user.dir"));
        
        // 모든 시스템 속성 출력
        System.out.println("\n=== 모든 시스템 속성 ===");
        System.getProperties().list(System.out);
        
        // 환경 변수 출력
        System.out.println("\n=== 주요 환경 변수 ===");
        System.out.println("PATH: " + System.getenv("PATH"));
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
        
        // 현재 시간 측정 (밀리초)
        long startTime = System.currentTimeMillis();
        
        // 간단한 연산 수행
        for (int i = 0; i < 10000000; i++) {
            // 의미 없는 연산 수행
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("\n=== 성능 측정 ===");
        System.out.println("작업 수행 시간: " + (endTime - startTime) + "ms");
        
        // 나노초 단위 시간 측정 (더 정밀한 시간 측정)
        long startNanoTime = System.nanoTime();
        
        for (int i = 0; i < 10000000; i++) {
            // 의미 없는 연산 수행
        }
        
        long endNanoTime = System.nanoTime();
        System.out.println("작업 수행 시간(나노초): " + (endNanoTime - startNanoTime) + "ns");
        
        // System.exit() 메소드 사용 예
        System.out.println("\n프로그램을 종료합니다.");
        // System.exit(0); // 주석 처리하여 예제 실행이 계속 진행되도록 함

    }
} 