package chapter6.labs.lab3;

import java.util.Scanner;

/**
 * Lab 3: 사용자 정의 예외와 예외 전파
 * 
 * 은행 계좌 관리 시스템을 구현하고 다양한 예외 상황을 처리하는 프로그램입니다.
 */
public class BankingApp {
    public static void main(String[] args) {
        System.out.println("Lab 3: 사용자 정의 예외와 예외 전파 실습");
        System.out.println("은행 계좌 관리 시스템에 오신 것을 환영합니다!");
        
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();
        
        // 초기 계좌 생성 (테스트용)
        try {
            bankingSystem.createAccount("1001", "홍길동", 10000);
            bankingSystem.createAccount("1002", "김철수", 20000);
            System.out.println("초기 계좌가 생성되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("초기 계좌 생성 중 오류: " + e.getMessage());
        }
        
        boolean running = true;
        while (running) {
            try {
                displayMenu();
                System.out.print("메뉴를 선택하세요: ");
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1: // 계좌 생성
                        createAccount(scanner, bankingSystem);
                        break;
                    case 2: // 계좌 조회
                        viewAccount(scanner, bankingSystem);
                        break;
                    case 3: // 입금
                        deposit(scanner, bankingSystem);
                        break;
                    case 4: // 출금
                        withdraw(scanner, bankingSystem);
                        break;
                    case 5: // 계좌 이체
                        transfer(scanner, bankingSystem);
                        break;
                    case 6: // 모든 계좌 보기
                        bankingSystem.displayAllAccounts();
                        break;
                    case 0: // 종료
                        running = false;
                        System.out.println("프로그램을 종료합니다. 감사합니다!");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("오류: 숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println("시스템 오류: " + e.getMessage());
            }
            
            // 메뉴 계속 표시를 위한 구분선
            System.out.println("\n----------------------------------------");
        }
        
        scanner.close();
    }
    
    /**
     * 메뉴 표시 메소드
     */
    private static void displayMenu() {
        System.out.println("\n=== 은행 계좌 관리 시스템 ===");
        System.out.println("1. 계좌 생성");
        System.out.println("2. 계좌 조회");
        System.out.println("3. 입금");
        System.out.println("4. 출금");
        System.out.println("5. 계좌 이체");
        System.out.println("6. 모든 계좌 보기");
        System.out.println("0. 종료");
    }
    
    /**
     * 계좌 생성 메소드
     */
    private static void createAccount(Scanner scanner, BankingSystem bankingSystem) {
        // TODO: 사용자로부터 계좌번호, 예금주 이름, 초기 잔액을 입력받아 계좌를 생성하세요.
        // TODO: IllegalArgumentException을 처리하세요.
        
    }
    
    /**
     * 계좌 조회 메소드
     */
    private static void viewAccount(Scanner scanner, BankingSystem bankingSystem) {
        // TODO: 사용자로부터 계좌번호를 입력받아 계좌 정보를 조회하세요.
        // TODO: InvalidAccountException을 처리하세요.
        
    }
    
    /**
     * 입금 메소드
     */
    private static void deposit(Scanner scanner, BankingSystem bankingSystem) {
        // TODO: 사용자로부터 계좌번호와 입금액을 입력받아 입금 처리하세요.
        // TODO: InvalidAccountException과 IllegalArgumentException을 처리하세요.
        
    }
    
    /**
     * 출금 메소드
     */
    private static void withdraw(Scanner scanner, BankingSystem bankingSystem) {
        // TODO: 사용자로부터 계좌번호와 출금액을 입력받아 출금 처리하세요.
        // TODO: InvalidAccountException, InsufficientBalanceException, IllegalArgumentException을 처리하세요.
        
    }
    
    /**
     * 계좌 이체 메소드
     */
    private static void transfer(Scanner scanner, BankingSystem bankingSystem) {
        // TODO: 사용자로부터 출금 계좌번호, 입금 계좌번호, 이체 금액을 입력받아 이체 처리하세요.
        // TODO: InvalidAccountException, InsufficientBalanceException, IllegalArgumentException을 처리하세요.
        
    }
} 