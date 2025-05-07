package chapter8.examples.ex1;

import java.util.Arrays;

/**
 * Ex 1: 제네릭 메소드 예제
 * 
 * 제네릭 메소드 구현 및 활용 예제입니다.
 */
public class GenericMethodExample {
    
    /**
     * 두 개의 객체를 교환하는 제네릭 메소드
     * @param <T> 타입 매개변수
     * @param a 첫 번째 객체
     * @param b 두 번째 객체
     */
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * 배열에서 특정 원소의 인덱스를 찾는 제네릭 메소드
     * @param <T> 타입 매개변수
     * @param array 검색할 배열
     * @param element 찾을 원소
     * @return 찾은
     */
    public static <T> int findIndex(T[] array, T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1; // 원소를 찾지 못한 경우
    }
    
    /**
     * 배열의 모든 원소를 출력하는 제네릭 메소드
     * @param <T> 타입 매개변수
     * @param array 출력할 배열
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Integer 타입 배열 예제
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("원본 배열: " + Arrays.toString(numbers));
        
        // swap 메소드 호출
        swap(numbers, 0, 4);
        System.out.println("0번과 4번 원소 교환 후: " + Arrays.toString(numbers));
        
        // findIndex 메소드 호출
        int index = findIndex(numbers, 3);
        System.out.println("숫자 3의 인덱스: " + index);
        
        // String 타입 배열 예제
        String[] fruits = {"사과", "바나나", "오렌지", "포도", "딸기"};
        System.out.println("\n원본 배열: " + Arrays.toString(fruits));
        
        // swap 메소드 호출
        swap(fruits, 1, 3);
        System.out.println("1번과 3번 원소 교환 후: " + Arrays.toString(fruits));
        
        // findIndex 메소드 호출
        index = findIndex(fruits, "딸기");
        System.out.println("'딸기'의 인덱스: " + index);
        
        // printArray 메소드 호출
        System.out.println("\n정수 배열 출력:");
        printArray(numbers);
        
        System.out.println("문자열 배열 출력:");
        printArray(fruits);
    }
} 