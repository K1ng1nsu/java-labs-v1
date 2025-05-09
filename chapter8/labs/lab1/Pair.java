package chapter8.labs.lab1;

import java.util.Objects;

/**
 * Lab 1: 제네릭 클래스 구현하기
 * <p>
 * 제네릭 타입 매개변수를 사용한 Pair 클래스를 구현하세요.
 * 두 가지 값을 저장할 수 있는 클래스입니다.
 */
public class Pair<K, V> {
    // TODO: K와 V 타입의 필드를 선언하세요.
    private K key;
    private V value;


    // TODO: 기본 생성자를 구현하세요.

    public Pair() {
    }


    // TODO: 두 매개변수를 받는 생성자를 구현하세요.

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }


    // TODO: getter와 setter 메소드를 구현하세요.

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    // TODO: toString 메소드를 오버라이드하세요.

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }


    // TODO: equals 메소드를 오버라이드하세요.
    // TODO: hashCode 메소드를 오버라이드하세요.

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(getKey(), pair.getKey()) && Objects.equals(getValue(), pair.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }


}