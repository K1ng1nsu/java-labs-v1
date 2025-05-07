package chapter6.examples.ex4;

import java.util.Scanner;

/**
 * 사용자 정의 예외 사용 예제
 * 
 * 이 예제는 사용자 정의 예외를 생성하고 사용하는 방법을 보여줍니다.
 */
public class CustomExceptionExample {
    // 에러 코드 상수
    public static final int ERROR_INVALID_AGE = 1001;
    public static final int ERROR_INVALID_NAME = 1002;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine();
            
            System.out.print("나이를 입력하세요: ");
            int age = Integer.parseInt(scanner.nextLine());
            
            // 유효성 검사 메소드 호출
            validatePerson(name, age);
            
            // 여기까지 오면 유효한 데이터
            System.out.println("입력 정보가 유효합니다.");
            System.out.println("이름: " + name + ", 나이: " + age);
            
        } catch (CustomException e) {
            // 사용자 정의 예외 처리
            System.out.println("오류 발생: " + e.getMessage());
            System.out.println("오류 코드: " + e.getErrorCode());
            
            // 오류 코드에 따른 추가 처리
            if (e.getErrorCode() == ERROR_INVALID_AGE) {
                System.out.println("나이는 0보다 크고 150보다 작아야 합니다.");
            } else if (e.getErrorCode() == ERROR_INVALID_NAME) {
                System.out.println("이름은 2자 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 잘못되었습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * 사용자 입력 데이터 유효성 검사 메소드
     * @param name 사용자 이름
     * @param age 사용자 나이
     * @throws CustomException 유효하지 않은 입력 데이터인 경우
     */
    private static void validatePerson(String name, int age) throws CustomException {
        // 이름 유효성 검사
        if (name == null || name.trim().length() < 2) {
            throw new CustomException("이름이 유효하지 않습니다.", ERROR_INVALID_NAME);
        }
        
        // 나이 유효성 검사
        if (age <= 0 || age >= 150) {
            throw new CustomException("나이가 유효하지 않습니다.", ERROR_INVALID_AGE);
        }
    }
} 