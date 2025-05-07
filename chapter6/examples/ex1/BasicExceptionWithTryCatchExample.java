package chapter6.examples.ex1;

import java.util.Scanner;

/**
 * 기본 예외처리 예제
 * 
 * 이 예제는 간단한 try-catch 구문을 사용하여 예외를 처리하는 방법을 보여줍니다.
 */
public class BasicExceptionWithTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
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
            
        } catch (NumberFormatException e) {
            // 숫자 형식이 잘못된 경우 처리
            System.out.println("오류: 올바른 숫자 형식이 아닙니다.");
            System.out.println("예외 메시지: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // 배열 인덱스 범위를 벗어난 경우 처리
            System.out.println("오류: 배열 인덱스가 범위를 벗어났습니다.");
            System.out.println("예외 메시지: " + e.getMessage());
        } catch (Exception e) {
            // 기타 모든 예외 처리
            System.out.println("예상치 못한 오류가 발생했습니다.");
            System.out.println("예외 타입: " + e.getClass().getName());
            System.out.println("예외 메시지: " + e.getMessage());
        } finally {
            // 항상 실행되는 코드 블록
            System.out.println("프로그램을 종료합니다.");
            scanner.close();
        }
    }
} 