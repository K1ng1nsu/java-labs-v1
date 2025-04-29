package chapter2.labs.lab2;

import java.util.Scanner;

/**
 * switch 문을 사용한 조건 분기 실습
 */
public class SwitchStatementLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 사용자로부터 요일을 입력받아 해당 요일의 활동을 출력하는 프로그램
        System.out.println("요일을 입력하세요 (예: 월요일): ");
        String day = scanner.nextLine();
        
        // TODO: 입력받은 요일에 따라 다음과 같이 출력하세요.
        // "월요일" - "회의가 있습니다."
        // "화요일" - "보고서를 작성합니다."
        // "수요일" - "팀 미팅이 있습니다."
        // "목요일" - "외근이 있습니다."
        // "금요일" - "주간 업무를 정리합니다."
        // "토요일" 또는 "일요일" - "휴일입니다."
        // 그 외 - "잘못된 요일입니다."
        
        
        // 2. 간단한 계산기 프로그램
        System.out.println("\n첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();
        System.out.println("두 번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        System.out.println("연산자를 입력하세요 (+, -, *, /): ");
        String operator = scanner.nextLine();
        
        // TODO: 입력받은 두 숫자와 연산자를 이용하여 계산 결과를 출력하세요.
        // "+" - 두 수의 합
        // "-" - 첫 번째 수에서 두 번째 수를 뺀 값
        // "*" - 두 수의 곱
        // "/" - 첫 번째 수를 두 번째 수로 나눈 값 (두 번째 수가 0이면 "0으로 나눌 수 없습니다." 출력)
        // 그 외 - "잘못된 연산자입니다."
        
        
        // 3. 월 입력받아 계절 출력하기
        System.out.println("\n월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();
        
        // TODO: 입력받은 월에 따라 계절을 출력하세요.
        // 12, 1, 2월 - "겨울"
        // 3, 4, 5월 - "봄"
        // 6, 7, 8월 - "여름"
        // 9, 10, 11월 - "가을"
        // 범위를 벗어난 값 - "잘못된 월입니다."
        
        
        scanner.close();
    }
} 