package chapter8.labs.lab1;

import java.util.List;

/**
 * Lab 1: 제네릭 유틸리티 클래스
 * <p>
 * 다양한 제네릭 메소드를 포함한 유틸리티 클래스를 구현하세요.
 */
public class PairUtils {

    /**
     * 두 객체로 구성된 Pair 객체를 생성하는 정적 메소드
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<K, V>(key, value);
    }


    /**
     * Pair 객체의 키와 값을 바꾼 새로운 Pair 객체를 반환하는 메소드
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static <T> Pair<T, T> swap(Pair<T, T> pair) {
        T temp = pair.getKey();
        pair.setKey(pair.getValue());
        pair.setValue(temp);

        return pair;
    }


    /**
     * 숫자 타입의 Pair 객체에서 키와 값의 합을 계산하는 메소드
     * Number 또는 그 하위 클래스 타입만 허용
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static <K extends Number, V extends Number> double sum(Pair<K, V> pair) {
        Number key = pair.getKey();
        double num1 = key.doubleValue();
        Number value = pair.getValue();
        double num2 = value.doubleValue();

        return num1 + num2;
    }

    /**
     * 두 Pair 객체를 비교하는 메소드
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> boolean comparePairs(Pair<K, V> pair1, Pair<K, V> pair2) {
        return pair1.equals(pair2);
    }


    /**
     * 리스트에서 조건에 맞는 요소로 구성된 Pair 객체를 찾는 메소드
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static <K, V> Pair<K, V> getPairFromList(List<Pair<K, V>> list, Pair<K, V> pair) {
        for (Pair<K, V> p : list) {
            if (comparePairs(p, pair)) {
                return pair;
            }
        }
        return null;
    }


    /**
     * 와일드카드를 사용하여 Pair 객체의 모든 가능한 타입을 처리하는 메소드
     * <p>
     * TODO: 메소드를 구현하세요.
     */
    public static void acceptAllPairs(Pair<?, ?> pair) {
        System.out.println("Pair's Key Type: " + pair.getKey().getClass() + " Value Type: " + pair.getValue().getClass());
    }

} 