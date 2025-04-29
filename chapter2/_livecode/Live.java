package chapter2._livecode;

/**
 * 자바의 조건문과 반복문을 실습하는 Live 코드
 */
public class Live {
    public static void main(String[] args) {
        // 조건문 예제
        System.out.println("===== 조건문 =====");
        
        // if 문 예제
        int number = 10;
        if (number > 0) {
            System.out.println("양수입니다.");
        } else {
            System.out.println("음수입니다.");
        }
        
        // switch 문 예제
        String day = "월요일";
        switch (day) {
            case "월요일":
                System.out.println("회의가 있습니다.");
                break;
            case "화요일":
                System.out.println("보고서를 작성합니다.");
                break;
            case "수요일":
                System.out.println("팀 미팅이 있습니다.");
                break;
            default:
                System.out.println("휴일입니다.");
                break;
        }
        
        // 반복문 예제
        System.out.println("\n===== 반복문 =====");
        
        // for 반복문 예제
        System.out.println("for 반복문:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("반복: " + i);
        }
        
        // while 반복문 예제
        System.out.println("\nwhile 반복문:");
        int i = 1;
        while (i <= 5) {
            System.out.println("반복: " + i);
            i++;
        }
        
        // do-while 반복문 예제
        System.out.println("\ndo-while 반복문:");
        int j = 1;
        do {
            System.out.println("반복: " + j);
            j++;
        } while (j <= 5);
    }
} 