package chapter2.examples.ex1;

/**
 * 자바의 if 조건문 예제
 */
public class IfStatement {
    public static void main(String[] args) {
        // 기본 if 문
        int number = 10;
        if (number > 0) {
            System.out.println("number는 양수입니다.");
        }
        
        // if-else 문
        int x = -5;
        if (x >= 0) {
            System.out.println("x는 양수 또는 0입니다.");
        } else {
            System.out.println("x는 음수입니다.");
        }
        
        // if-else if-else 문
        int score = 85;
        if (score >= 90) {
            System.out.println("A 등급");
        } else if (score >= 80) {
            System.out.println("B 등급");
        } else if (score >= 70) {
            System.out.println("C 등급");
        } else if (score >= 60) {
            System.out.println("D 등급");
        } else {
            System.out.println("F 등급");
        }
        
        // 중첩 if 문
        int a = 10;
        int b = 20;
        if (a > 0) {
            if (b > 0) {
                System.out.println("a와 b 모두 양수입니다.");
            } else {
                System.out.println("a는 양수이지만 b는 양수가 아닙니다.");
            }
        }
        
        // 조건 연산자(삼항 연산자)를 이용한 if 문 대체
        int num1 = 5;
        int num2 = 7;
        int max = (num1 > num2) ? num1 : num2;
        System.out.println("두 수 중 큰 값: " + max);
    }
} 