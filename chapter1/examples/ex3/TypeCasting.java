package chapter1.examples.ex3;

/**
 * 자바의 형변환(Type Casting) 예제
 */
public class TypeCasting {
    public static void main(String[] args) {
        // 1. 자동 형변환(Implicit Casting, 프로모션)
        // 작은 타입에서 큰 타입으로 자동 변환됨
        System.out.println("===== 자동 형변환 =====");
        byte byteValue = 10;
        int intValue = byteValue;  // byte -> int 자동 형변환
        System.out.println("byte 값: " + byteValue);
        System.out.println("int 값: " + intValue);
        
        char charValue = 'A';
        intValue = charValue;      // char -> int 자동 형변환
        System.out.println("char 값: " + charValue);
        System.out.println("int 값: " + intValue);  // 'A'의 유니코드 값 65
        
        intValue = 500;
        long longValue = intValue; // int -> long 자동 형변환
        System.out.println("int 값: " + intValue);
        System.out.println("long 값: " + longValue);
        
        int intValue2 = 3;
        double doubleValue = intValue2; // int -> double 자동 형변환
        System.out.println("int 값: " + intValue2);
        System.out.println("double 값: " + doubleValue);

        // 2. 명시적 형변환(Explicit Casting, 캐스팅 연산자 사용)
        // 큰 타입에서 작은 타입으로 변환할 때 데이터 손실 가능성 있음
        // (타입)
        System.out.println("\n===== 명시적 형변환 =====");
        double doubleValue2 = 3.14159;
        intValue = (int) doubleValue2;  // double -> int 명시적 형변환 (소수점 손실)
        System.out.println("double 값: " + doubleValue2);
        System.out.println("int 값: " + intValue);
        
        intValue = 129;
        byteValue = (byte) intValue;    // int -> byte 명시적 형변환 (범위 초과로 값 손실)
        System.out.println("int 값: " + intValue);
        System.out.println("byte 값: " + byteValue);  // byte 범위(-128~127)를 벗어나 오버플로우 발생
        
        long longValue2 = 10000000000L;
        intValue = (int) longValue2;    // long -> int 명시적 형변환 (범위 초과로 값 손실)
        System.out.println("long 값: " + longValue2);
        System.out.println("int 값: " + intValue);

        // 3. 연산에서의 형변환
        System.out.println("\n===== 연산에서의 형변환 =====");
        
        // 정수 연산 (int보다 작은 타입(byte, short, char)은 int로 변환 후 연산)
        byte b1 = 10;
        byte b2 = 20;

//        byte b3 = b1 + b2;   // 컴파일 에러! b1과 b2는 int로 변환 후 연산됨
        int i3 = b1 + b2;      // int 타입으로 결과 저장
        byte b3 = (byte)(b1 + b2);  // 명시적 형변환으로 해결
        
        System.out.println("b1 + b2 (int 결과): " + i3);
        System.out.println("b1 + b2 (byte로 캐스팅): " + b3);
        
        // 정수와 실수 연산 (실수 타입으로 자동 형변환 후 연산)
        int i4 = 10;
        double d4 = 3.5;
        double result1 = i4 + d4;  // i4가 double로 자동 형변환 후 연산
        System.out.println("i4 + d4 = " + result1);
        
        // 4. 문자열과 다른 타입의 연산
        System.out.println("\n===== 문자열과의 연산 =====");
        String str1 = "Java" + 8;  // 문자열 + 정수 = 문자열 연결
        String str2 = 3.14 + "Pi"; // 실수 + 문자열 = 문자열 연결
        String str3 = "결과: " + true; // 문자열 + 불린 = 문자열 연결
        
        System.out.println(str1);  // "Java8"
        System.out.println(str2);  // "3.14Pi"
        System.out.println(str3);  // "결과: true"
        
        // 5. 타입 변환 메소드
        System.out.println("\n===== 타입 변환 메소드 =====");
        
        // 문자열 -> 기본 타입
        int i5 = Integer.parseInt("123");
        double d5 = Double.parseDouble("3.14");
        boolean b5 = Boolean.parseBoolean("true");
        
        System.out.println("Integer.parseInt(\"123\") = " + i5);
        System.out.println("Double.parseDouble(\"3.14\") = " + d5);
        System.out.println("Boolean.parseBoolean(\"true\") = " + b5);
        
        // 기본 타입 -> 문자열
        String str4 = Integer.toString(456);
        String str5 = Double.toString(2.718);
        String str6 = Boolean.toString(false);
        
        System.out.println("Integer.toString(456) = " + str4);
        System.out.println("Double.toString(2.718) = " + str5);
        System.out.println("Boolean.toString(false) = " + str6);
    }
} 