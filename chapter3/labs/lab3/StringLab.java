package chapter3.labs.lab3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문자열 처리하기 실습
 */
public class StringLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 단어 수 계산하기
        System.out.println("===== 단어 수 계산하기 =====");
        System.out.println("문장을 입력하세요: ");
        String sentence = scanner.nextLine();

        // TODO: 입력받은 문장에서 단어 수를 계산하여 출력하세요.
        // 힌트: split() 메소드를 사용하여 문자열을 공백으로 분리하세요.

        String[] words = sentence.split(" ");

        System.out.println("words : " + Arrays.toString(words));
        System.out.println("Sentence has " + words.length + " words");

        // 2. 문자열 뒤집기
        System.out.println("\n===== 문자열 뒤집기 =====");
        System.out.println("문자열을 입력하세요: ");
        String original = scanner.nextLine();

        // TODO: 입력받은 문자열을 뒤집어서 출력하세요.
        // 힌트: 문자 배열로 변환하거나, StringBuilder의 reverse() 메소드를 활용하세요.
        char[] charArray = original.toCharArray();
        char[] reversedArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            reversedArray[charArray.length - 1 - i] = charArray[i];
        }
        String reversed = String.valueOf(reversedArray);
        System.out.println("reversed : " + reversed);

        // 3. 특정 문자 등장 횟수 계산하기
        System.out.println("\n===== 특정 문자 등장 횟수 계산하기 =====");
        System.out.println("문자열을 입력하세요: ");
        String text = scanner.nextLine();
        System.out.println("찾을 문자를 입력하세요: ");
        char target = scanner.next().charAt(0);

        // TODO: 입력받은 문자열에서 특정 문자의 등장 횟수를 계산하여 출력하세요.
        // 힌트: 문자열을 순회하면서 각 문자와 대상 문자를 비교하세요.
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                count++;
            }
        }

        System.out.println(target + " count : " + count);

        // 4. 회문(Palindrome) 검사
        System.out.println("\n===== 회문(Palindrome) 검사 =====");
        scanner.nextLine(); // 버퍼 비우기
        System.out.println("문자열을 입력하세요: ");
        String palindrome = scanner.nextLine();

        // TODO: 입력받은 문자열이 회문인지 검사하여 결과를 출력하세요.
        // 회문은 앞으로 읽으나 뒤로 읽으나 같은 단어나 문장을 의미합니다 (예: "level", "civic").
        // 힌트: 문자열을 뒤집은 후 원래 문자열과 비교하세요.
        boolean isPalindrome = true;
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != palindrome.charAt(palindrome.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) {
            System.out.println("The word you just entered '" + palindrome + "' is a palindrome." );
        }else{
            System.out.println("The word you just entered '" + palindrome + "' isn't a palindrome." );
        }


        scanner.close();
    }
} 