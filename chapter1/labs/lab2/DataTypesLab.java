package chapter1.labs.lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Lab 2: 자바 데이터 타입 실습
 * <p>
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;

        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float e = 5;
        double f = 6;

        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char g = 'a';

        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean h = true;

        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        BigDecimal bd = new BigDecimal("83").divide(new BigDecimal("1.78").multiply(new BigDecimal("1.78")), RoundingMode.FLOOR);

        System.out.println(bd);

        double bmi = 83.0 / (1.78 * 1.78);
        System.out.println(bmi);

    }
} 