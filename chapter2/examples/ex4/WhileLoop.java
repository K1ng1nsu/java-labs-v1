package chapter2.examples.ex4;

/**
 * 자바의 while 및 do-while 반복문 예제
 */
public class WhileLoop {
    public static void main(String[] args) {
        // 기본 while 반복문
        System.out.println("기본 while 반복문:");
        int i = 1;
        while (i <= 5) {
            System.out.println("반복 " + i + "번째");
            i++;
        }
        
        // while 반복문을 이용한 합계 계산
        System.out.println("\n1부터 10까지의 합계:");
        int sum = 0;
        int num = 1;
        while (num <= 10) {
            sum += num;
            num++;
        }
        System.out.println("합계: " + sum);
        
        // while 반복문 내에서 break 사용
        System.out.println("\nwhile에서 break 사용:");
        int j = 1;
        while (j <= 10) {
            if (j == 6) {
                break; // j가 6이 되면 반복문 종료
            }
            System.out.println("숫자: " + j);
            j++;
        }
        
        // while 반복문 내에서 continue 사용
        System.out.println("\nwhile에서 continue 사용:");
        int k = 0;
        while (k < 10) {
            k++;
            if (k % 2 == 0) {
                continue; // 짝수일 경우 아래 코드를 실행하지 않고 다음 반복으로 넘어감
            }
            System.out.println("홀수: " + k);
        }
        
        // do-while 반복문 (적어도 한 번은 실행됨)
        System.out.println("\ndo-while 반복문:");
        int m = 1;
        do {
            System.out.println("반복 " + m + "번째");
            m++;
        } while (m <= 5);
        
        // do-while로 메뉴 구현 예제
        System.out.println("\n메뉴 예제 (do-while):");
        int choice = 3; // 사용자의 선택 (예시 값)
        do {
            System.out.println("메뉴:");
            System.out.println("1. 새 게임");
            System.out.println("2. 계속하기");
            System.out.println("3. 설정");
            System.out.println("4. 종료");
            System.out.println("선택한 메뉴: " + choice);
            
            // 실제 프로그램에서는 여기서 사용자 입력을 받음
            // Scanner scanner = new Scanner(System.in);
            // choice = scanner.nextInt();
            
            // 예제를 위해 강제로 종료
            choice = 4; // 종료 조건으로 설정
        } while (choice != 4);
        System.out.println("프로그램을 종료합니다.");
        
        // 무한 루프 (주의: 실행 시 종료 조건 필요)
        /*
        System.out.println("\n무한 루프 예제:");
        while (true) {
            System.out.println("무한 반복");
            break; // 무한 루프 방지를 위한 break
        }
        */
    }
} 