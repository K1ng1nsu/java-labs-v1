package chapter3.labs.lab4;

import java.util.Scanner;

import static chapter3.labs.lab4.EnumLab.DayOfWeek.SUNDAY;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();

        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.

        Day day = Day.fromKorean(input);

        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("평일입니다.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말입니다.");
                break;
            default:
                System.out.println("잘못된 입력.");
        }

        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();

        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.

        Season seasonByNumOfMonth = Season.getSeasonByNumOfMonth(month);
        System.out
                .println(month + "월은 " + seasonByNumOfMonth.getKorean() + "입니다. " + seasonByNumOfMonth.getDescription()
                        + "이며 평균 기온은 " + seasonByNumOfMonth.getAverageTemperature() + "℃입니다.");

        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");

        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.

        TaskStatus taskStatus = TaskStatus.PENDING;
        String userInput;
        do {
            System.out.print("현재 상태는 " + taskStatus + " 입니다. next 나 exit를 입력해주세요.");
            userInput = scanner.nextLine();
            if (userInput.equals("next")) {
                taskStatus = taskStatus.nextStatus();
            }

        } while (!userInput.equals("exit"));

        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        // scanner.nextLine(); // 버퍼 비우기

        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.
        System.out.print("정수를 입력하세요. : ");
        int num1 = scanner.nextInt();
        System.out.print("정수를 입력하세요. : ");
        int num2 = scanner.nextInt();
        System.out.print("연산자를 입력하세요 +, -, *, / : ");
        String strOperator = scanner.next();
        Operator operator = Operator.getOperator(strOperator);

        System.out.print(num1 + " " + operator + " " + num2 + " = " + operator.calculate(num1, num2));

        scanner.close();
    }

    public enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    }
}