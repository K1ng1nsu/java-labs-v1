package chapter10.labs.lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 기본 스레드 활용 실습
 *
 * 이 실습에서는 Thread 클래스와 Runnable 인터페이스를 활용하여
 * 스레드를 생성하고 제어하는 방법을 연습합니다.
 */
public class ThreadBasicsLab {

    public static void main(String[] args) {
        System.out.println("=== 스레드 기본 실습 ===");
        
        // TODO: 아래 작업을 완성하세요.
        
        // 파트 1: Thread 클래스 상속을 통한 스레드 구현
        System.out.println("\n=== 파트 1: Thread 클래스 상속 ===");
        
        /* TODO: CountdownThread 클래스의 인스턴스를 생성하고 실행하세요.
         * - 카운트다운 시작 값: 10
         * - 대기 시간: 1초 (1000ms)
         * 
         * 예상 출력:
         * 카운트다운: 10
         * 카운트다운: 9
         * ...
         * 카운트다운: 1
         * 카운트다운 완료!
         */
        
        // 여기에 코드를 작성하세요.
        
        
        /* TODO: 또 다른 CountdownThread를 생성하고 스레드의 상태를 확인하세요.
         * 1. 스레드 생성 후 상태 출력
         * 2. 스레드 시작 후 상태 출력
         * 3. 스레드 실행 중 상태 출력 (Thread.sleep 사용)
         * 4. 스레드 종료 후 상태 출력
         */
        
        // 여기에 코드를 작성하세요.
        
        
        // 파트 2: Runnable 인터페이스 구현을 통한 스레드 생성
        System.out.println("\n=== 파트 2: Runnable 인터페이스 구현 ===");
        
        /* TODO: FileProcessor 클래스의 인스턴스를 생성하고 Thread에 전달하여 실행하세요.
         * - 처리할 파일 경로: "test.txt" (클래스 경로에 미리 파일을 생성해두세요)
         *   간단한 내용의 텍스트 파일로, 몇 줄의 텍스트가 포함되어 있어야 합니다.
         */
        
        // 여기에 코드를 작성하세요.
        
        
        /* TODO: 다중 스레드 실행 - 여러 개의 FileProcessor를 병렬로 실행하세요.
         * 1. 3개의 FileProcessor 인스턴스 생성 (다른 파일 또는 같은 파일)
         * 2. 각각을 별도의 스레드로 실행
         * 3. 모든 스레드가 종료될 때까지 메인 스레드가 대기하도록 구현 (join 메소드 사용)
         * 4. 모든 스레드 종료 후 메시지 출력
         */
        
        // 여기에 코드를 작성하세요.
        
        
        // 파트 3: 스레드 제어
        System.out.println("\n=== 파트 3: 스레드 제어 ===");
        
        /* TODO: 인터럽트 기능을 구현하여 실행 중인 스레드를 중지시키세요.
         * 1. 긴 시간(예: 20초) 동안 실행되는 CountdownThread 생성
         * 2. 3초 후에 해당 스레드에 인터럽트 발생시키기
         * 3. CountdownThread 클래스에 인터럽트 처리 로직 추가
         *    (InterruptedException catch 시 적절한 처리)
         */
        
        // 여기에 코드를 작성하세요.
        
        
        /* TODO: 우선순위가 다른 여러 스레드를 생성하고 실행하세요.
         * 1. 우선순위가 낮은 스레드 생성 (Thread.MIN_PRIORITY)
         * 2. 우선순위가 중간인 스레드 생성 (Thread.NORM_PRIORITY)
         * 3. 우선순위가 높은 스레드 생성 (Thread.MAX_PRIORITY)
         * 4. 실행 결과 관찰 및 분석
         * 
         * 참고: 우선순위의 효과는 운영체제와 JVM 구현에 따라 다를 수 있습니다.
         */
        
        // 여기에 코드를 작성하세요.
        
        
        System.out.println("\n모든 실습이 완료되었습니다!");
    }
    
    /**
     * 카운트다운을 수행하는 스레드 클래스
     * 
     * Thread 클래스를 상속받아 구현합니다.
     */
    static class CountdownThread extends Thread {
        private int count;
        private long delayMillis;
        
        // TODO: 생성자를 구현하세요.
        // - Thread 이름 설정
        // - count와 delayMillis 초기화
        
        
        // TODO: run() 메소드를 구현하세요.
        // - count부터 1까지 카운트다운
        // - 각 카운트마다 delayMillis 만큼 대기 (Thread.sleep 사용)
        // - InterruptedException 처리
        // - 카운트다운 완료 시 메시지 출력
        
    }
    
    /**
     * 파일을 처리하는 Runnable 구현 클래스
     * 
     * Runnable 인터페이스를 구현합니다.
     */
    static class FileProcessor implements Runnable {
        private String filePath;
        
        // TODO: 생성자를 구현하세요.
        // - filePath 초기화
        
        
        // TODO: run() 메소드를 구현하세요.
        // - filePath에서 파일 읽기
        // - 파일의 각 줄 출력
        // - 현재 스레드 이름과 함께 출력
        // - IOException 처리
        @Override
        public void run() {
            // TODO: 구현하세요
            try {
                processFile();
            } catch (IOException e) {
                System.out.println(Thread.currentThread().getName() + 
                    ": 파일 처리 중 오류 발생 - " + e.getMessage());
            }
        }
        
        /**
         * 파일을 읽고 내용을 처리하는 메소드
         */
        private void processFile() throws IOException {
            // TODO: 파일 읽기 및 처리 코드를 작성하세요.
            // - BufferedReader와 FileReader 사용
            // - 파일의 각 줄을 읽고 출력
            // - 처리 시간을 시뮬레이션하기 위해 각 줄 처리 후 짧은 대기 시간 추가
            
        }
    }
} 