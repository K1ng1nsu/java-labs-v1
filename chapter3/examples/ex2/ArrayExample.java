package chapter3.examples.ex2;

import java.util.Arrays;

/**
 * 자바의 배열과 다차원 배열 예제
 */
public class ArrayExample {
    public static void main(String[] args) {
        // 배열 선언과 초기화
        System.out.println("===== 배열 선언과 초기화 =====");
        
        // 방법 1: 선언과 동시에 초기화
        int[] numbers1 = {10, 20, 30, 40, 50};
        
        // 방법 2: 배열 선언 후 초기화
        int[] numbers2 = new int[5];
        numbers2[0] = 10;
        numbers2[1] = 20;
        numbers2[2] = 30;
        numbers2[3] = 40;
        numbers2[4] = 50;
        
        // 방법 3: 배열 타입과 크기 지정 후 초기화
        int numbers3[] = new int[]{10, 20, 30, 40, 50};
        
        // 배열 출력
        System.out.println("numbers1: " + Arrays.toString(numbers1));
        System.out.println("numbers2: " + Arrays.toString(numbers2));
        System.out.println("numbers3: " + Arrays.toString(numbers3));
        
        // 배열 요소 접근
        System.out.println("\n===== 배열 요소 접근 =====");
        System.out.println("numbers1의 첫 번째 요소: " + numbers1[0]);
        System.out.println("numbers1의 세 번째 요소: " + numbers1[2]);
        System.out.println("numbers1의 마지막 요소: " + numbers1[numbers1.length - 1]);
        
        // 배열 순회
        System.out.println("\n===== 배열 순회 방법 =====");
        
        // 1. 기본 for 루프
        System.out.println("1. 기본 for 루프");
        for (int i = 0; i < numbers1.length; i++) {
            System.out.println("numbers1[" + i + "] = " + numbers1[i]);
        }
        
        // 2. 향상된 for 루프 (for-each)
        System.out.println("\n2. 향상된 for 루프 (for-each)");
        for (int number : numbers1) {
            System.out.println("요소: " + number);
        }
        
        // 다양한 타입의 배열
        System.out.println("\n===== 다양한 타입의 배열 =====");
        
        // 문자열 배열
        String[] fruits = {"사과", "바나나", "오렌지", "포도", "딸기"};
        System.out.println("과일 배열: " + Arrays.toString(fruits));
        
        // 문자 배열
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        System.out.println("문자 배열: " + Arrays.toString(chars));
        System.out.println("문자열로 변환: " + new String(chars));
        
        // boolean 배열
        boolean[] flags = {true, false, true, true, false};
        System.out.println("불리언 배열: " + Arrays.toString(flags));
        
        // 배열 복사
        System.out.println("\n===== 배열 복사 =====");
        
        // 1. Arrays.copyOf 사용
        int[] copied1 = Arrays.copyOf(numbers1, numbers1.length);
        System.out.println("Arrays.copyOf: " + Arrays.toString(copied1));
        
        // 2. System.arraycopy 사용
        int[] copied2 = new int[numbers1.length];
        System.arraycopy(numbers1, 0, copied2, 0, numbers1.length);
        System.out.println("System.arraycopy: " + Arrays.toString(copied2));
        
        // 3. clone 메소드 사용
        int[] copied3 = numbers1.clone();
        System.out.println("clone 메소드: " + Arrays.toString(copied3));
        
        // 다차원 배열
        System.out.println("\n===== 다차원 배열 =====");
        
        // 2차원 배열 선언과 초기화
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        
        // 2차원 배열 출력
        System.out.println("2차원 배열 출력:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 향상된 for 루프로 2차원 배열 출력
        System.out.println("\n향상된 for 루프로 2차원 배열 출력:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        // 가변 크기 2차원 배열
        System.out.println("\n===== 가변 크기 2차원 배열 =====");
        int[][] jaggedArray = new int[3][];
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[3];
        jaggedArray[2] = new int[4];
        
        // 요소 초기화
        int value = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = value++;
            }
        }
        
        // 가변 크기 배열 출력
        System.out.println("가변 크기 배열 출력:");
        for (int[] row : jaggedArray) {
            System.out.println(Arrays.toString(row));
        }
        
        // 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");
        int[] unsorted = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        System.out.println("정렬 전: " + Arrays.toString(unsorted));
        
        Arrays.sort(unsorted);
        System.out.println("정렬 후: " + Arrays.toString(unsorted));
    }
} 