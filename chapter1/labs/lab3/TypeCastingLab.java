package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte a = 1;
        int b = a;
        long c = b;
        float d = c;
        double e = d;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기

        double a1 = 1;
        float b1 = (float)a1;
        long c1 = (long)b1;
        int d1 = (int)c1;
        char e1 = (char)d1;
        short f1 = (short)e1;
        byte g1 = (byte)f1;

        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
        System.out.println(d1);
        System.out.println(e1);
        System.out.println(f1);
        System.out.println(g1);

        
        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기
        int a2 = 130;
        byte b2 = (byte)a2;
        
        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기

        String a3 = "123";
        int b3 = Integer.parseInt(a3);

        String c3 = "3.14";
        double d3 = Double.parseDouble(c3);
        
        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기

        int a4 = 456;
        double b4 = 7.89;

        String c4 = String.valueOf(a4);
        String d4 = String.valueOf(b4);

        System.out.println(c4);
        System.out.println(d4);

        
    }
} 