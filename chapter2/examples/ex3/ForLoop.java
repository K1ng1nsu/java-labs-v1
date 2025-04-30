package chapter2.examples.ex3;

/**
 * 자바의 for 반복문 예제
 */
public class ForLoop {
    public static void main(String[] args) {
        // 기본 for 반복문
        System.out.println("기본 for 반복문:");
        for (int i = 1; i < 5; i++) {
            System.out.println("반복 " + i + "번째");
        }
        
        // 중첩 for 반복문을 이용한 구구단 출력
        System.out.println("\n구구단 일부 출력:");
        for (int i = 2; i <= 4; i++) {

            System.out.println(i + "단:");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));

            }
            System.out.println();
        }
        
        // for 반복문을 이용한 배열 접근
        System.out.println("배열 요소 출력:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // 향상된 for 반복문 (for-each)
        System.out.println("\n향상된 for 반복문:");
        String[] fruits = {"사과", "바나나", "포도", "오렌지", "딸기"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // for 반복문 내에서 continue 사용
        System.out.println("\ncontinue 사용 예제:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                break; // 짝수일 경우 아래 코드를 실행하지 않고 다음 반복으로 넘어감
            }
            System.out.println("홀수: " + i);
        }
        
        // for 반복문 내에서 break 사용
        System.out.println("\nbreak 사용 예제:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; // i가 6이 되면 반복문 종료
            }
            System.out.println("숫자: " + i);
        }
        
        // 무한 루프 (주의: 실행 시 종료 조건 필요)
        /*
        System.out.println("\n무한 루프 예제:");
        for (;;) {
            System.out.println("무한 반복");
            break; // 무한 루프 방지를 위한 break
        }
        */
    }
} 