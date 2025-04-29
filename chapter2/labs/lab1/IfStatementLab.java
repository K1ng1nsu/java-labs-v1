package chapter2.labs.lab1;

import java.util.Scanner;

/**
 * if 문을 사용한 조건 분기 실습
 */
public class IfStatementLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 사용자로부터 숫자를 입력받아 양수, 음수, 또는 0인지 판별하는 프로그램
        System.out.println("숫자를 입력하세요: ");
        int number = scanner.nextInt();
        
        // TODO: 입력받은 숫자가 양수, 음수, 0인지 판별하고 출력하세요.
        // 양수이면 "양수입니다."
        // 음수이면 "음수입니다."
        // 0이면 "0입니다."
        
        
        // 2. 두 숫자를 입력받아 큰 수를 출력하는 프로그램
        System.out.println("\n첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();
        System.out.println("두 번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();
        
        // TODO: 두 숫자 중 큰 수를 출력하세요.
        // 만약 두 수가 같다면 "두 수는 같습니다."라고 출력하세요.
        
        
        // 3. 점수를 입력받아 학점을 출력하는 프로그램
        System.out.println("\n시험 점수를 입력하세요 (0-100): ");
        int score = scanner.nextInt();
        
        // TODO: 입력받은 점수에 따라 학점을 출력하세요.
        // 90-100: "A"
        // 80-89: "B"
        // 70-79: "C"
        // 60-69: "D"
        // 0-59: "F"
        // 범위를 벗어난 점수: "잘못된 점수입니다."
        
        
        scanner.close();
    }
} 