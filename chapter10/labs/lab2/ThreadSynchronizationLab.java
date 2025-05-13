package chapter10.labs.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 스레드 동기화 실습
 * <p>
 * 이 실습에서는 여러 스레드가 공유 자원에 안전하게 접근할 수 있도록
 * 동기화 기법을 적용하는 방법을 연습합니다.
 */
public class ThreadSynchronizationLab {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 스레드 동기화 실습 ===");

        // 파트 1: synchronized 키워드를 활용한 동기화
        System.out.println("\n=== 파트 1: synchronized 활용 ===");

        /* TODO: BankAccount 클래스를 사용하여 다음 작업을 수행하세요:
         * 1. 계좌 객체 생성 (초기 잔액: 1000)
         * 2. 다수의 입금 스레드와 출금 스레드 생성
         * 3. 모든 스레드 실행 및 완료 대기
         * 4. 최종 잔액 확인
         */

        // 여기에 코드를 작성하세요.
        BankAccount bankAccount = new BankAccount(1000);

        Thread[] depositThreads = new Thread[10];
        for (int i = 0; i < depositThreads.length; i++) {
            depositThreads[i] = new Thread(() -> {
                bankAccount.deposit(100);
            });
        }

        Thread[] withdrawThreads = new Thread[10];
        for (int i = 0; i < withdrawThreads.length; i++) {
            withdrawThreads[i] = new Thread(() -> {
                bankAccount.withdraw(400);
            });
        }

        for (Thread thread : depositThreads) thread.start();
        for (Thread thread : withdrawThreads) thread.start();

        // 파트 2: Lock과 Condition을 활용한 동기화
        System.out.println("\n=== 파트 2: Lock과 Condition 활용 ===");

        /* TODO: MessageQueue 클래스를 사용하여 생산자-소비자 패턴을 구현하세요:
         * 1. MessageQueue 객체 생성
         * 2. 생산자 스레드 여러 개 생성
         * 3. 소비자 스레드 여러 개 생성
         * 4. 모든 스레드 실행 및 일정 시간 후 중지
         */

        // 여기에 코드를 작성하세요.
        MessageQueue messageQueue = new MessageQueue(10);

        Thread[] producerThreads = new Thread[10];
        for (int i = 0; i < producerThreads.length; i++) {
            producerThreads[i] = new Producer("Producer " + i, messageQueue);
        }

        Thread[] consumerThreads = new Thread[10];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new Consumer("Consumer " + i, messageQueue);
        }
        for (Thread thread : producerThreads) thread.start();
        for (Thread thread : consumerThreads) thread.start();

        Thread.sleep(5000);
        for (Thread thread : producerThreads) ((Producer) thread).stopProducing();
        for (Thread thread : consumerThreads) ((Consumer) thread).stopConsuming();

        // 파트 3: 스레드 안전한 싱글톤 패턴 구현
        System.out.println("\n=== 파트 3: 스레드 안전한 싱글톤 패턴 ===");

        /* TODO: SafeSingleton 클래스의 인스턴스를 여러 스레드에서 동시에 요청하세요:
         * 1. 여러 스레드 생성 (각 스레드는 SafeSingleton.getInstance() 호출)
         * 2. 각 스레드에서 얻은 인스턴스가 모두 동일한지 확인
         */

        // 여기에 코드를 작성하세요.
        Thread[] singleThreads = new Thread[10];
        for (int i = 0; i < singleThreads.length; i++) {
            singleThreads[i] = new Thread(() -> {
                SafeSingleton instance = SafeSingleton.getInstance();
                System.out.println(instance.getInstanceId());
            });
        }
        for (Thread thread : singleThreads) thread.start();


        System.out.println("\n모든 실습이 완료되었습니다!");
    }

    /**
     * 스레드 안전한 은행 계좌 클래스
     * <p>
     * synchronized 키워드를 사용하여 동기화를 구현합니다.
     */
    static class BankAccount {
        private int balance;

        public BankAccount(int initialBalance) {
            this.balance = initialBalance;
        }

        // TODO: deposit 메소드를 구현하세요.
        // - 동기화된 메소드로 구현
        // - 잔액 증가 로직 구현
        // - 입금 내역 출력
        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("after deposit: " + balance);
        }


        // TODO: withdraw 메소드를 구현하세요.
        // - synchronized 블록을 사용하여 구현
        // - 잔액이 충분한 경우에만 출금 진행
        // - 출금 내역 출력
        public void withdraw(int amount) {
            synchronized (this) {
                if (balance < amount) {
                    System.out.println("can't withdraw amount " + amount);
                } else {
                    balance -= amount;
                    System.out.println("after withdraw: " + balance);
                }
            }
        }


        // 잔액 조회 메소드
        public synchronized int getBalance() {
            return balance;
        }
    }

    /**
     * Lock과 Condition을 사용한 메시지 큐 클래스
     * <p>
     * 생산자-소비자 패턴을 구현합니다.
     */
    static class MessageQueue {
        private final List<String> messages = new ArrayList<>();
        private final int capacity;
        private final Lock lock = new ReentrantLock();
        private final Condition notEmpty = lock.newCondition();
        private final Condition notFull = lock.newCondition();

        public MessageQueue(int capacity) {
            this.capacity = capacity;
        }

        // TODO: put 메소드를 구현하세요.
        // - Lock 획득 및 해제
        // - 큐가 가득 찼을 때 대기 (Condition.await)
        // - 메시지 추가 후 대기 중인 소비자에게 신호 (Condition.signal)
        public void put(String message) throws InterruptedException {
            // TODO: 구현하세요
            lock.lock();

            while (messages.size() == capacity) {
                System.out.println("message queue is full");
                notFull.await();
            }
            messages.add(message);
            notEmpty.signal();

            lock.unlock();

        }

        // TODO: take 메소드를 구현하세요.
        // - Lock 획득 및 해제
        // - 큐가 비어있을 때 대기 (Condition.await)
        // - 메시지 꺼내고 대기 중인 생산자에게 신호 (Condition.signal)
        public String take() throws InterruptedException {
            // TODO: 구현하세요

            lock.lock();
            while (messages.isEmpty()) {
                System.out.println("message queue is empty");
                notEmpty.await();
            }
            String message = messages.get(0);
            messages.remove(0);

            notFull.signal();
            lock.unlock();

            return message; // 임시 반환값
        }
    }

    /**
     * 스레드 안전한 싱글톤 패턴 클래스
     * <p>
     * DCL(Double-Checked Locking) 패턴을 사용합니다.
     */
    static class SafeSingleton {
        // TODO: volatile 키워드를 사용한 인스턴스 변수 선언
        volatile private static SafeSingleton instance;


        // TODO: private 생성자 구현

        private SafeSingleton() {
        }


        // TODO: DCL 패턴을 사용한 getInstance 메소드 구현
        // - 첫 번째 검사: 동기화 블록 외부
        // - 두 번째 검사: 동기화 블록 내부
        public static SafeSingleton getInstance() {
            if (instance == null) {
                synchronized (SafeSingleton.class) {
                    if (instance == null) {
                        instance = new SafeSingleton();
                    }
                }
            }
            return instance;
        }


        // 싱글톤 인스턴스 식별을 위한 메소드
        public String getInstanceId() {
            return "Singleton Instance @" + Integer.toHexString(hashCode());
        }
    }

    // 생산자 스레드 클래스
    static class Producer extends Thread {
        private final MessageQueue queue;
        private volatile boolean running = true;

        public Producer(String name, MessageQueue queue) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                int count = 0;
                while (running && count < 10) {
                    String message = getName() + " - Message " + (++count);
                    queue.put(message);
                    System.out.println(getName() + " produced: " + message);
                    Thread.sleep((long) (Math.random() * 1000));
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
            System.out.println(getName() + " finished producing");
        }

        public void stopProducing() {
            running = false;
            interrupt();
        }
    }

    // 소비자 스레드 클래스
    static class Consumer extends Thread {
        private final MessageQueue queue;
        private volatile boolean running = true;

        public Consumer(String name, MessageQueue queue) {
            super(name);
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (running) {
                    String message = queue.take();
                    System.out.println(getName() + " consumed: " + message);
                    Thread.sleep((long) (Math.random() * 1500));
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
            }
            System.out.println(getName() + " finished consuming");
        }

        public void stopConsuming() {
            running = false;
            interrupt();
        }
    }
} 