package chapter10.examples.ex2;

/**
 * 스레드 동기화 예제
 * 
 * 이 예제에서는 synchronized 키워드를 사용한 스레드 동기화 방법을 보여줍니다:
 * - synchronized 메소드
 * - synchronized 블록
 * - 동기화되지 않은 코드와 비교
 */
public class SynchronizationExample {

    // 공유 자원 클래스
    static class Counter {
        private int count = 0;
        
        // 동기화되지 않은 메소드 - 스레드 안전하지 않음
        public void incrementUnsafe() {
            count++;
        }
        
        // synchronized 키워드로 메소드 전체 동기화
        public synchronized void incrementSafe() {
            count++;
        }
        
        // synchronized 블록으로 특정 부분만 동기화
        public void incrementWithBlock() {
            // 다른 비동기 코드가 여기에 올 수 있음
            synchronized(this) {
                count++;
            }
            // 다른 비동기 코드가 여기에 올 수 있음
        }
        
        public int getCount() {
            return count;
        }
        
        public void resetCount() {
            count = 0;
        }
    }
    
    // 카운터 증가 작업을 수행하는 스레드
    static class CounterThread extends Thread {
        private final Counter counter;
        private final int increments;
        private final boolean useSynchronization;
        private final boolean useBlock;
        
        public CounterThread(String name, Counter counter, int increments, 
                            boolean useSynchronization, boolean useBlock) {
            super(name);
            this.counter = counter;
            this.increments = increments;
            this.useSynchronization = useSynchronization;
            this.useBlock = useBlock;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < increments; i++) {
                if (useSynchronization) {
                    counter.incrementSafe();
                } else if (useBlock) {
                    counter.incrementWithBlock();
                } else {
                    counter.incrementUnsafe();
                }
            }
            System.out.println(getName() + " 완료");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int incrementsPerThread = 100000;
        
        System.out.println("=== 동기화 없이 실행 ===");
        runTest(counter, incrementsPerThread, false, false);
        
        counter.resetCount();
        System.out.println("\n=== synchronized 메소드로 실행 ===");
        runTest(counter, incrementsPerThread, true, false);
        
        counter.resetCount();
        System.out.println("\n=== synchronized 블록으로 실행 ===");
        runTest(counter, incrementsPerThread, false, true);
    }
    
    private static void runTest(Counter counter, int incrementsPerThread, 
                               boolean useSynchronization, boolean useBlock) throws InterruptedException {
        // 세 개의 스레드 생성
        Thread t1 = new CounterThread("스레드-1", counter, incrementsPerThread, useSynchronization, useBlock);
        Thread t2 = new CounterThread("스레드-2", counter, incrementsPerThread, useSynchronization, useBlock);
        Thread t3 = new CounterThread("스레드-3", counter, incrementsPerThread, useSynchronization, useBlock);
        
        // 시작 시간 기록
        long startTime = System.currentTimeMillis();
        
        // 스레드 시작
        t1.start();
        t2.start();
        t3.start();
        
        // 모든 스레드가 완료될 때까지 대기
        t1.join();
        t2.join();
        t3.join();
        
        // 종료 시간 기록
        long endTime = System.currentTimeMillis();
        
        // 결과 출력
        System.out.println("예상 카운트: " + (incrementsPerThread * 3));
        System.out.println("실제 카운트: " + counter.getCount());
        System.out.println("실행 시간: " + (endTime - startTime) + "ms");
        
        // 결과 확인
        if (counter.getCount() == incrementsPerThread * 3) {
            System.out.println("결과: 정확히 계산됨 ✓");
        } else {
            System.out.println("결과: 경쟁 상태(Race Condition) 발생! ✗");
            System.out.println("  " + (incrementsPerThread * 3 - counter.getCount()) + "번의 증가가 손실됨");
        }
    }
} 