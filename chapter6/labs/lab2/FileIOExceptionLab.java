package chapter6.labs.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Lab 2: 파일 입출력과 예외처리
 * 
 * 텍스트 파일을 읽고 내용을 분석하는 프로그램입니다.
 * 파일 입출력 작업에서 발생할 수 있는 다양한 예외를 처리해야 합니다.
 */
public class FileIOExceptionLab {
    public static void main(String[] args) {
        System.out.println("Lab 2: 파일 입출력과 예외처리 실습");
        
        Scanner scanner = new Scanner(System.in);
        
        // TODO: 사용자로부터 읽을 파일 이름을 입력받으세요.
        
        
        // TODO: try-with-resources 구문을 사용하여 파일을 읽고 내용을 분석하세요.
        // 1. BufferedReader를 사용하여 파일을 한 줄씩 읽습니다.
        // 2. 각 줄의 길이와 단어 수를 계산합니다.
        // 3. 파일의 전체 줄 수, 단어 수, 문자 수를 출력합니다.
        // 4. 다음 예외 상황을 처리하세요:
        //    - FileNotFoundException: 파일이 존재하지 않는 경우
        //    - IOException: 파일 읽기 중 오류가 발생한 경우
        //    - 기타 예외: 기타 모든 예외 상황
        
        
        // 참고: 단어 수 계산을 위해 String.split("\\s+") 메소드를 활용할 수 있습니다.
        
        
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }
} 