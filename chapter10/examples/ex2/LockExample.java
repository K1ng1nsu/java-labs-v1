package chapter10.examples.ex2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock 인터페이스 활용 예제
 * 
 * 이 예제에서는 java.util.concurrent.locks 패키지의 Lock 인터페이스를 활용한 
 * 동기화 방법을 보여줍니다:
 * - ReentrantLock
 * - ReadWriteLock
 */
public class LockExample {

    // ReentrantLock을 사용하는 공유 자원
    static class BankAccount {
        private final Lock lock = new ReentrantLock();
        private int balance;
        
        public BankAccount(int initialBalance) {
            this.balance = initialBalance;
        }
        
        // synchronized 대신 Lock을 사용한 메소드
        public void deposit(int amount) {
            // 락 획득
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": 입금 시작 (현재 잔액: " + balance + ")");
                balance += amount;
                System.out.println(Thread.currentThread().getName() + ": " + amount + "원 입금 완료 (잔액: " + balance + ")");
                // 실제 작업이 길다고 가정
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": 입금 중 인터럽트 발생");
            } finally {
                // finally 블록에서 락 해제 (중요!)
                lock.unlock();
            }
        }
        
        public void withdraw(int amount) {
            // 락 획득 시도 (락을 얻을 수 없으면 대기)
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": 출금 시작 (현재 잔액: " + balance + ")");
                
                if (balance >= amount) {
                    // 실제 작업이 길다고 가정
                    Thread.sleep(200);
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + ": " + amount + "원 출금 완료 (잔액: " + balance + ")");
                } else {
                    System.out.println(Thread.currentThread().getName() + ": 잔액 부족으로 출금 실패");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": 출금 중 인터럽트 발생");
            } finally {
                // finally 블록에서 락 해제 (중요!)
                lock.unlock();
            }
        }
        
        public int getBalance() {
            return balance;
        }
    }
    
    // ReadWriteLock을 사용하는 공유 데이터
    static class SharedData {
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        private final Lock readLock = rwLock.readLock();
        private final Lock writeLock = rwLock.writeLock();
        
        private String data = "초기 데이터";
        
        // 읽기 작업 - 여러 스레드가 동시에 읽을 수 있음
        public String readData() {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": 데이터 읽기 시작");
                // 읽기 작업이 길다고 가정
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + ": 데이터 읽기 완료 - " + data);
                return data;
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": 읽기 중 인터럽트 발생");
                return null;
            } finally {
                readLock.unlock();
            }
        }
        
        // 쓰기 작업 - 쓰기 중에는 다른 읽기/쓰기 작업이 차단됨
        public void writeData(String newData) {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": 데이터 쓰기 시작");
                // 쓰기 작업이 길다고 가정
                Thread.sleep(200);
                this.data = newData;
                System.out.println(Thread.currentThread().getName() + ": 데이터 쓰기 완료 - " + newData);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": 쓰기 중 인터럽트 발생");
            } finally {
                writeLock.unlock();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ReentrantLock 예제 ===");
        BankAccount account = new BankAccount(1000);
        
        // 입금 스레드
        Thread deposit1 = new Thread(() -> {
            account.deposit(500);
        }, "입금스레드-1");
        
        Thread deposit2 = new Thread(() -> {
            account.deposit(300);
        }, "입금스레드-2");
        
        // 출금 스레드
        Thread withdraw1 = new Thread(() -> {
            account.withdraw(700);
        }, "출금스레드-1");
        
        Thread withdraw2 = new Thread(() -> {
            account.withdraw(500);
        }, "출금스레드-2");
        
        // 스레드 시작
        deposit1.start();
        withdraw1.start();
        deposit2.start();
        withdraw2.start();
        
        // 모든 스레드 종료 대기
        deposit1.join();
        deposit2.join();
        withdraw1.join();
        withdraw2.join();
        
        System.out.println("최종 잔액: " + account.getBalance() + "원");
        
        System.out.println("\n=== ReadWriteLock 예제 ===");
        SharedData sharedData = new SharedData();
        
        // 읽기 스레드 여러 개
        Thread[] readers = new Thread[5];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Thread(() -> {
                sharedData.readData();
            }, "읽기스레드-" + (i + 1));
        }
        
        // 쓰기 스레드
        Thread writer1 = new Thread(() -> {
            sharedData.writeData("새로운 데이터-1");
        }, "쓰기스레드-1");
        
        Thread writer2 = new Thread(() -> {
            sharedData.writeData("새로운 데이터-2");
        }, "쓰기스레드-2");
        
        // 읽기 스레드 먼저 시작
        for (Thread reader : readers) {
            reader.start();
        }
        
        // 쓰기 스레드 시작
        Thread.sleep(100); // 읽기 스레드가 먼저 시작하도록 잠시 대기
        writer1.start();
        
        // 더 많은 읽기 스레드와 쓰기 스레드를 번갈아 실행
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                sharedData.readData();
            }, "추가읽기스레드-" + i).start();
        }
        
        Thread.sleep(100);
        writer2.start();
        
        // 모든 스레드 종료 대기 (간단하게 처리)
        Thread.sleep(1000);
        
        System.out.println("\n모든 작업이 완료되었습니다.");
    }
} 