package chapter10.examples.ex1;

/**
 * 스레드 제어 기본 예제
 * 
 * 이 예제에서는 스레드의 생명주기와 제어 메소드를 보여줍니다:
 * - 스레드 상태(Thread States)
 * - 스레드 우선순위(Priority)
 * - 스레드 제어 메소드(join, sleep, interrupt)
 */
public class ThreadControlExample {

    // 카운트다운을 수행하는 스레드
    static class CountdownThread extends Thread {
        private final int seconds;
        private boolean paused = false;
        
        public CountdownThread(String name, int seconds) {
            super(name);
            this.seconds = seconds;
        }
        
        // 스레드 일시 중지
        public synchronized void pauseThread() {
            paused = true;
        }
        
        // 스레드 재개
        public synchronized void resumeThread() {
            paused = false;
            notify(); // 일시 중지된 스레드 깨우기
        }
        
        @Override
        public void run() {
            System.out.println(getName() + " 스레드 시작 (상태: " + getState() + ")");
            
            for (int i = seconds; i > 0; i--) {
                System.out.println(getName() + ": " + i + "초 남음");
                
                try {
                    // 일시 중지 요청을 확인하고 처리
                    synchronized (this) {
                        while (paused) {
                            System.out.println(getName() + " 일시 중지됨");
                            wait(); // 재개 신호를 기다림
                            System.out.println(getName() + " 재개됨");
                        }
                    }
                    
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    System.out.println(getName() + " 인터럽트 발생 (상태: " + getState() + ")");
                    return; // 스레드 종료
                }
            }
            
            System.out.println(getName() + " 카운트다운 완료 (상태: " + getState() + ")");
        }
    }
    
    // 특정 작업을 반복하는 스레드
    static class WorkerThread extends Thread {
        private volatile boolean running = true;
        
        public WorkerThread(String name) {
            super(name);
        }
        
        // 스레드 중지 요청
        public void stopThread() {
            running = false;
        }
        
        @Override
        public void run() {
            int count = 0;
            
            while (running && count < 10) {
                System.out.println(getName() + " 작업 중... (" + (++count) + ")");
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " 인터럽트 발생");
                    break;
                }
            }
            
            System.out.println(getName() + " 종료됨");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 스레드 제어 예제 ===");
        
        // 1. 카운트다운 스레드 생성
        CountdownThread countdown = new CountdownThread("카운트다운", 5);
        
        // 스레드 우선순위 설정 (1-10, 기본값 5)
        countdown.setPriority(Thread.MAX_PRIORITY); // 10
        
        // 2. 작업 스레드 생성
        WorkerThread worker = new WorkerThread("작업자");
        worker.setPriority(Thread.MIN_PRIORITY); // 1
        
        // 스레드 시작
        System.out.println("스레드 시작 전 (상태: " + countdown.getState() + ")");
        countdown.start();
        worker.start();
        
        // 스레드 상태 출력
        try {
            Thread.sleep(2000);
            System.out.println("\n=== 스레드 상태 ===");
            System.out.println("카운트다운 스레드 상태: " + countdown.getState());
            System.out.println("작업자 스레드 상태: " + worker.getState());
            
            // 카운트다운 스레드 일시 중지
            System.out.println("\n=== 스레드 일시 중지 ===");
            countdown.pauseThread();
            Thread.sleep(2000);
            
            // 카운트다운 스레드 재개
            System.out.println("\n=== 스레드 재개 ===");
            countdown.resumeThread();
            Thread.sleep(1000);
            
            // 작업자 스레드 중지 요청
            System.out.println("\n=== 작업자 스레드 중지 요청 ===");
            worker.stopThread();
            
            // 모든 스레드가 종료될 때까지 대기
            System.out.println("\n모든 스레드 종료 대기 중...");
            countdown.join();
            worker.join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== 스레드 최종 상태 ===");
        System.out.println("카운트다운 스레드 상태: " + countdown.getState());
        System.out.println("작업자 스레드 상태: " + worker.getState());
        
        System.out.println("\n모든 스레드가 종료되었습니다.");
    }
} 