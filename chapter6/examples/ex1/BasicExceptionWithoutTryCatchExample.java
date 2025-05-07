package chapter6.examples.ex1;

import java.util.Scanner;

/**
 * 기본 예외처리 예제
 * 
 * 이 예제는 의도적으로 예외를 발생시키는 예제입니다.
 */
public class BasicExceptionWithoutTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 숫자 입력 받기
        System.out.print("정수를 입력하세요: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("입력한 숫자: " + number);

        // 배열에 접근 시도
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("5번째 요소: " + numbers[4]);

        // 잘못된 배열 인덱스 접근 시도
        System.out.print("접근할 배열 인덱스를 입력하세요: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("선택한 요소: " + numbers[index]);


    }
} 