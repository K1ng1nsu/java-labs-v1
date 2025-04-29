package chapter2.examples.ex2;

/**
 * 자바의 switch 조건문 예제
 */
public class SwitchStatement {
    public static void main(String[] args) {
        // 기본 switch 문 (정수형)
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;
            default:
                System.out.println("잘못된 요일");
                break;
        }
        
        // 문자열을 이용한 switch 문 (Java 7 이상)
        String fruit = "사과";
        switch (fruit) {
            case "사과":
                System.out.println("사과는 빨간색입니다.");
                break;
            case "바나나":
                System.out.println("바나나는 노란색입니다.");
                break;
            case "키위":
                System.out.println("키위는 녹색입니다.");
                break;
            default:
                System.out.println("알 수 없는 과일입니다.");
                break;
        }
        
        // break가 없는 경우 (fall-through)
        int month = 8;
        String season;
        switch (month) {
            case 12: case 1: case 2:
                season = "겨울";
                break;
            case 3: case 4: case 5:
                season = "봄";
                break;
            case 6: case 7: case 8:
                season = "여름";
                break;
            case 9: case 10: case 11:
                season = "가을";
                break;
            default:
                season = "알 수 없음";
        }
        System.out.println(month + "월은 " + season + "입니다.");
        
        // Java 12+ 이상의 새로운 switch 표현식 (참고용)
        // 사용 환경이 Java 12 이상인 경우에만 활성화하세요
        /*
        int value = 2;
        String result = switch (value) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> "Other";
        };
        System.out.println("결과: " + result);
        */
    }
} 