package chapter2.labs.lab3;

import java.util.Scanner;

/**
 * for 반복문을 사용한 반복 실습
 */
public class ForLoopLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 1부터 10까지의 합을 계산하여 출력하는 프로그램
        System.out.println("1부터 10까지의 합 계산:");
        
        // TODO: 1부터 10까지의 합을 계산하여 출력하세요.
        // 합계를 저장할 변수를 선언하고, for 반복문을 사용하여 1부터 10까지의 숫자를 더하세요.
        
        
        // 2. 구구단을 출력하는 프로그램
        System.out.println("\n출력할 구구단의 단을 입력하세요 (2-9): ");
        int dan = scanner.nextInt();
        
        // TODO: 입력받은 단의 구구단을 출력하세요.
        // for 반복문을 사용하여 해당 단의 1부터 9까지의 곱셈 결과를 출력하세요.
        
        
        // 3. 팩토리얼 계산하기
        System.out.println("\n팩토리얼을 계산할 숫자를 입력하세요: ");
        int n = scanner.nextInt();
        
        // TODO: 입력받은 숫자의 팩토리얼을 계산하여 출력하세요.
        // 팩토리얼은 1부터 n까지의 모든 정수를 곱한 값입니다.
        // 예: 5! = 5 × 4 × 3 × 2 × 1 = 120
        
        
        scanner.close();
    }
} 