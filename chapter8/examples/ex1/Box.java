package chapter8.examples.ex1;

/**
 * Ex 1: 기본 제네릭 클래스 예제
 * 
 * 제네릭 타입 매개변수 T를 사용한 Box 클래스입니다.
 * 모든 타입의 객체를 저장할 수 있습니다.
 */
public class Box<T> {
    // 제네릭 타입의 객체를 저장할 필드
    private T item;
    
    // 기본 생성자
    public Box() {
    }
    
    // 매개변수가 있는 생성자
    public Box(T item) {
        this.item = item;
    }
    
    // getter 메소드
    public T getItem() {
        return item;
    }
    
    // setter 메소드
    public void setItem(T item) {
        this.item = item;
    }
    
    // 현재 박스에 저장된 아이템이 null인지 확인하는 메소드
    public boolean isEmpty() {
        return item == null;
    }
    
    @Override
    public String toString() {
        return item != null ? item.toString() : "Empty box";
    }
} 