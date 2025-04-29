package chapter3.labs.lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 활용하기 실습
 */
public class ArrayLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. 정수형 배열 활용
        System.out.println("===== 정수형 배열 활용 =====");
        
        // TODO: 5개의 정수를 입력받아 배열에 저장하고, 합계와 평균을 계산하여 출력하세요.
        // 힌트: Scanner를 이용하여 사용자로부터 입력을 받으세요.

        int[] array = new int[5];

        for(int i = 0; i < array.length; i++){
            System.out.print("정수를 입력하세요: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Sum of array : " + Arrays.stream(array).sum());
        System.out.println("average of array : " + Arrays.stream(array).sum() / array.length);


        // 2. 문자열 배열 활용
        System.out.println("\n===== 문자열 배열 활용 =====");
        
        // TODO: 5개의 이름을 입력받아 배열에 저장하고, 특정 문자(예: 'A')로 시작하는 이름을 검색하여 출력하세요.
        // 힌트: String 클래스의 startsWith() 또는 charAt() 메소드를 활용하세요.
        String[] strArray = new String[5];
        for(int i = 0; i < strArray.length; i++){
            System.out.print("이름을 입력하세요:");
            strArray[i] = scanner.next();
        }

        for(String s : strArray){
            if(s.startsWith("A")){
                System.out.println("Someone whose name starts with 'A' is "+s);
            }
        }


        // 3. 배열 정렬
        System.out.println("\n===== 배열 정렬 =====");
        
        // TODO: 사용자로부터 5개의 정수를 입력받아 배열에 저장한 후, 오름차순으로 정렬하여 출력하세요.
        // 힌트: 이중 반복문을 사용하여 버블 정렬 알고리즘을 구현하거나, Arrays.sort()를 활용하세요.

        int[] array2 = new int[5];
        for(int i = 0; i < array2.length; i++){
            System.out.print("정수를 입력하세요: ");
            array2[i] = scanner.nextInt();
        }
        Arrays.sort(array2);

        System.out.println("array2 : " + Arrays.toString(array2));

        
        // 4. 2차원 배열을 이용한 행렬 덧셈
        System.out.println("\n===== 2차원 배열을 이용한 행렬 덧셈 =====");
        
        // TODO: 두 개의 2x3 행렬을 입력받아 행렬 덧셈을 수행하고 결과를 출력하세요.
        // 힌트: 중첩 반복문을 사용하세요.

        int[][] array3 = new int[2][3];

        for(int i = 0; i < array3.length; i++){
            for(int j = 0; j < array3[i].length; j++){
                System.out.print("array3[" + i + "][" + j + "]: ");
                array3[i][j] = scanner.nextInt();
            }
        }

        int sumOfArray3 = 0;
        for(int[] row : array3){
            for(int col : row){
                sumOfArray3 += col;
            }
        }
        System.out.println("sumOfArray3 : " + sumOfArray3);


        // 5. 배열을 이용한 간단한 데이터 분석
        System.out.println("\n===== 배열을 이용한 데이터 분석 =====");
        
        // TODO: 10개의 정수를 입력받아 배열에 저장한 후, 최댓값, 최솟값, 중앙값(또는 평균)을 계산하여 출력하세요.
        // 힌트: 정렬을 활용하면 중앙값을 쉽게 찾을 수 있습니다.

        int[] array4 = new int[10];
        for(int i = 0; i < array4.length; i++){
            System.out.print("정수를 입력하세요. : ");
            array4[i] = scanner.nextInt();
        }

        System.out.println("Max value of array4 : " + Arrays.stream(array4).max().getAsInt());
        System.out.println("Min value of array4 : " + Arrays.stream(array4).min().getAsInt());
        System.out.println("Avg value of array4 : " + Arrays.stream(array4).sum() / array4.length);

        scanner.close();
    }
} 