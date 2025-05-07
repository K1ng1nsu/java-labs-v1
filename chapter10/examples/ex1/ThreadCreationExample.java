package chapter10.examples.ex1;

/**
 * 스레드 생성 기본 예제
 * 
 * 이 예제에서는 스레드를 생성하는 두 가지 방법을 보여줍니다:
 * 1. Thread 클래스 상속
 * 2. Runnable 인터페이스 구현
 */
public class ThreadCreationExample {

    // Thread 클래스 상속 방식
    static class MyThread extends Thread {
        private final String name;
        
        public MyThread(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " 스레드: " + i);
                try {
                    // 스레드 실행 중 잠시 대기
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(name + " 스레드 인터럽트 발생");
                    // 인터럽트 발생 시 스레드 종료
                    return;
                }
            }
            System.out.println(name + " 스레드 종료");
        }
    }
    
    // Runnable 인터페이스 구현 방식
    static class MyRunnable implements Runnable {
        private final String name;
        
        public MyRunnable(String name) {
            this.name = name;
        }
        
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " 작업: " + i);
                try {
                    // 스레드 실행 중 잠시 대기
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    System.out.println(name + " 작업 인터럽트 발생");
                    // 인터럽트 발생 시 스레드 종료
                    return;
                }
            }
            System.out.println(name + " 작업 종료");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 스레드 생성 예제 ===");
        System.out.println("메인 스레드 시작");
        
        // 1. Thread 클래스 상속 방식으로 스레드 생성
        MyThread thread1 = new MyThread("Thread-1");
        
        // 2. Runnable 인터페이스 구현 방식으로 스레드 생성
        Thread thread2 = new Thread(new MyRunnable("Runnable-1"));
        
        // 3. 익명 클래스로 Runnable 구현
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("익명 Runnable: " + i);
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        System.out.println("익명 Runnable 인터럽트 발생");
                        return;
                    }
                }
                System.out.println("익명 Runnable 종료");
            }
        });
        
        // 4. 람다식으로 Runnable 구현 (Java 8 이상)
        Thread thread4 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("람다 Runnable: " + i);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    System.out.println("람다 Runnable 인터럽트 발생");
                    return;
                }
            }
            System.out.println("람다 Runnable 종료");
        });
        
        // 스레드 시작
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        // 메인 스레드 작업 처리
        for (int i = 1; i <= 3; i++) {
            System.out.println("메인 스레드: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("메인 스레드 종료 대기 중");
        
        // 생성한 스레드들이 종료될 때까지 메인 스레드가 기다림
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("모든 스레드 종료 후 메인 스레드 종료");
    }
} 