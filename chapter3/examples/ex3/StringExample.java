package chapter3.examples.ex3;

/**
 * 자바의 문자열(String) 처리 예제
 */
public class StringExample {
    public static void main(String[] args) {
        // 문자열 생성
        System.out.println("===== 문자열 생성 =====");
        
        // 리터럴 방식으로 문자열 생성
        String str1 = "Hello, World!";
        // new 연산자를 사용한 문자열 생성
        String str2 = new String("Hello, World!");
        
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        
        // 문자열 비교
        System.out.println("\n===== 문자열 비교 =====");
        
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        
        // == 연산자는 참조를 비교 (동일한 객체인지 확인)
        System.out.println("s1 == s2: " + (s1 == s2)); // true (같은 객체를 참조)
        System.out.println("s1 == s3: " + (s1 == s3)); // false (다른 객체를 참조)
        
        // equals() 메소드는 내용을 비교
        System.out.println("s1.equals(s2): " + s1.equals(s2)); // true (내용이 같음)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (내용이 같음)
        
        // 문자열 메소드
        System.out.println("\n===== 문자열 메소드 =====");
        
        String text = "Java Programming Language";
        
        // 길이
        System.out.println("length(): " + text.length());
        
        // 문자 위치
        System.out.println("charAt(5): " + text.charAt(5));
        
        // 부분 문자열
        System.out.println("substring(5, 16): " + text.substring(5, 16));
        
        // 문자열 결합
        System.out.println("concat(): " + text.concat(" is fun!"));
        
        // 문자열 대체
        System.out.println("replace(): " + text.replace("Java", "Python"));
        
        // 대소문자 변환
        System.out.println("toUpperCase(): " + text.toUpperCase());
        System.out.println("toLowerCase(): " + text.toLowerCase());
        
        // 공백 제거
        String spacedText = "   Trim Example   ";
        System.out.println("trim(): '" + spacedText.trim() + "'");
        
        // 문자열 검색
        System.out.println("contains(): " + text.contains("Programming"));
        System.out.println("indexOf(): " + text.indexOf("Programming"));
        System.out.println("startsWith(): " + text.startsWith("Java"));
        System.out.println("endsWith(): " + text.endsWith("Language"));
        
        // 문자열 분할
        System.out.println("\n===== 문자열 분할 =====");
        
        String csvData = "사과,바나나,포도,딸기,오렌지";
        String[] fruits = csvData.split(",");
        
        System.out.println("split() 결과:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // 문자열 → 기본 타입 변환
        System.out.println("\n===== 문자열 → 기본 타입 변환 =====");
        
        String numStr = "123";
        int num = Integer.parseInt(numStr);
        System.out.println("Integer.parseInt(): " + (num + 10));
        
        String doubleStr = "3.14159";
        double pi = Double.parseDouble(doubleStr);
        System.out.println("Double.parseDouble(): " + (pi * 2));
        
        // 기본 타입 → 문자열 변환
        System.out.println("\n===== 기본 타입 → 문자열 변환 =====");
        
        int intValue = 42;
        String intStr1 = Integer.toString(intValue);
        String intStr2 = String.valueOf(intValue);
        String intStr3 = "" + intValue;
        
        System.out.println("Integer.toString(): " + intStr1);
        System.out.println("String.valueOf(): " + intStr2);
        System.out.println("문자열 연결: " + intStr3);
        
        // StringBuilder
        System.out.println("\n===== StringBuilder와 StringBuffer =====");
        
        // StringBuilder (단일 스레드 환경에서 더 효율적)
        StringBuilder sb = new StringBuilder();
        sb.append("Java ");
        sb.append("is ");
        sb.append("awesome!");
        System.out.println("StringBuilder 결과: " + sb.toString());

        // 성능 비교
        System.out.println("\n===== 성능 비교 =====");
        
        // String 연결 (효율성 낮음)
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += "a";
        }
        long endTime = System.nanoTime();
        System.out.println("String 연결 시간: " + (endTime - startTime) / 1000000 + "ms");
        
        // StringBuilder 사용 (효율성 높음)
        startTime = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("a");
        }
        result = builder.toString();
        endTime = System.nanoTime();
        System.out.println("StringBuilder 사용 시간: " + (endTime - startTime) / 1000000 + "ms");
    }
} 