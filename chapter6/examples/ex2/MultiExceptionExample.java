package chapter6.examples.ex2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *  try-with-resources 구문 사용 방법
 */
public class MultiExceptionExample {
    public static void main(String[] args) {
        // 파일 읽기 예제 - try-with-resources 사용
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("프로그램을 종료합니다.");
    }
} 