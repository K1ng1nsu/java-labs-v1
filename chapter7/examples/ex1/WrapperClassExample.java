package chapter7.examples.ex1;

/**
 * Integer Wrapper 클래스의 사용법 예제 (박싱, 언박싱, 문자열 변환 등)
 */
public class WrapperClassExample {
    public static void main(String[] args) {
        System.out.println("=== Integer 박싱과 언박싱 ===");

        int primitive = 100;

        // 박싱
        Integer boxed = Integer.valueOf(primitive);
        System.out.println("박싱된 Integer: " + boxed);

        // 언박싱
        int unboxed = boxed.intValue();
        System.out.println("언박싱된 int: " + unboxed);

        // 자동 박싱 & 언박싱
        Integer autoBoxed = 200;
        int autoUnboxed = autoBoxed;
        System.out.println("자동 박싱: " + autoBoxed);
        System.out.println("자동 언박싱: " + autoUnboxed);

        // 문자열 <-> 정수 변환
        int parsed = Integer.parseInt("123");
        String str = Integer.toString(456);
        System.out.println("문자열 \"123\" → int: " + parsed);
        System.out.println("int 456 → 문자열: " + str);

        // 진법 변환
        int decimal = 255;
        System.out.println("10진수 255 → 2진수: " + Integer.toBinaryString(decimal));
        System.out.println("10진수 255 → 16진수: " + Integer.toHexString(decimal));

        // Wrapper 상수
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);

        // 비교
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println("a == b: " + (a == b));         // true (캐시 범위)
        System.out.println("c == d: " + (c == d));         // false (캐시 범위 초과)
        System.out.println("a.equals(b): " + a.equals(b)); // true
        System.out.println("c.equals(d): " + c.equals(d)); // true
        System.out.println("Integer.compare(10, 20): " + Integer.compare(10, 20)); // -1
    }
}
