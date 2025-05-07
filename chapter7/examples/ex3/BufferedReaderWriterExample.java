package chapter7.examples.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 버퍼링을 사용한 문자 기반 파일 입출력 예제
 * BufferedReader와 BufferedWriter를 사용한 성능 향상
 */
public class BufferedReaderWriterExample {
    public static void main(String[] args) {
        String textFile = "chapter7/examples/ex3/buffered_sample.txt";
        
        // 성능 비교를 위한 대용량 텍스트 생성
        int lineCount = 10000;
        
        // 버퍼링 없이 파일 쓰기
        long nonBufferedTime = writeWithoutBuffering(textFile, lineCount);
        
        // 버퍼링을 사용하여 파일 쓰기
        long bufferedTime = writeWithBuffering(textFile, lineCount);
        
        // 성능 비교 출력
        System.out.println("\n=== 파일 쓰기 성능 비교 ===");
        System.out.println("버퍼링 없이 쓰기: " + nonBufferedTime + "ms");
        System.out.println("버퍼링 사용 쓰기: " + bufferedTime + "ms");
        System.out.println("성능 향상 비율: " + String.format("%.2f", (double)nonBufferedTime / bufferedTime) + "배");
        
        // 버퍼링 없이 파일 읽기
        long nonBufferedReadTime = readWithoutBuffering(textFile);
        
        // 버퍼링을 사용하여 파일 읽기
        long bufferedReadTime = readWithBuffering(textFile);
        
        // 읽기 성능 비교 출력
        System.out.println("\n=== 파일 읽기 성능 비교 ===");
        System.out.println("버퍼링 없이 읽기: " + nonBufferedReadTime + "ms");
        System.out.println("버퍼링 사용 읽기: " + bufferedReadTime + "ms");
        System.out.println("성능 향상 비율: " + String.format("%.2f", (double)nonBufferedReadTime / bufferedReadTime) + "배");
        
        // 행 단위 읽기 예제
        readFileByLine(textFile);
    }
    
    /**
     * 버퍼링 없이 파일에 쓰기
     * 
     * @param fileName 쓸 파일 이름
     * @param lineCount 쓸 라인 수
     * @return 소요 시간 (밀리초)
     */
    private static long writeWithoutBuffering(String fileName, int lineCount) {
        System.out.println("\n=== 버퍼링 없이 파일 쓰기 ===");
        long startTime = System.currentTimeMillis();
        
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int i = 1; i <= lineCount; i++) {
                writer.write("이 줄은 버퍼링 없이 쓴 " + i + "번째 라인입니다.\n");
            }
            System.out.println(lineCount + "개 라인 쓰기 완료!");
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    /**
     * 버퍼링을 사용하여 파일에 쓰기
     * 
     * @param fileName 쓸 파일 이름
     * @param lineCount 쓸 라인 수
     * @return 소요 시간 (밀리초)
     */
    private static long writeWithBuffering(String fileName, int lineCount) {
        System.out.println("\n=== 버퍼링 사용하여 파일 쓰기 ===");
        long startTime = System.currentTimeMillis();
        
        try (
            FileWriter writer = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            for (int i = 1; i <= lineCount; i++) {
                bufferedWriter.write("이 줄은 버퍼링을 사용하여 쓴 " + i + "번째 라인입니다.");
                bufferedWriter.newLine(); // 플랫폼에 맞는 줄바꿈 문자 추가
            }
            System.out.println(lineCount + "개 라인 쓰기 완료!");
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    /**
     * 버퍼링 없이 파일 읽기
     * 
     * @param fileName 읽을 파일 이름
     * @return 소요 시간 (밀리초)
     */
    private static long readWithoutBuffering(String fileName) {
        System.out.println("\n=== 버퍼링 없이 파일 읽기 ===");
        long startTime = System.currentTimeMillis();
        
        try (FileReader reader = new FileReader(fileName)) {
            int charCount = 0;
            int c;
            
            // 문자 단위로 읽기
            while ((c = reader.read()) != -1) {
                charCount++;
            }
            
            System.out.println("총 " + charCount + "개의 문자를 읽었습니다.");
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    /**
     * 버퍼링을 사용하여 파일 읽기
     * 
     * @param fileName 읽을 파일 이름
     * @return 소요 시간 (밀리초)
     */
    private static long readWithBuffering(String fileName) {
        System.out.println("\n=== 버퍼링 사용하여 파일 읽기 ===");
        long startTime = System.currentTimeMillis();
        
        try (
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            int charCount = 0;
            char[] buffer = new char[8192]; // 8KB 버퍼
            int charsRead;
            
            // 버퍼 단위로 읽기
            while ((charsRead = bufferedReader.read(buffer)) != -1) {
                charCount += charsRead;
            }
            
            System.out.println("총 " + charCount + "개의 문자를 읽었습니다.");
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    /**
     * BufferedReader를 사용한 행 단위 파일 읽기
     * 
     * @param fileName 읽을 파일 이름
     */
    private static void readFileByLine(String fileName) {
        System.out.println("\n=== 행 단위 파일 읽기 ===");
        
        try (
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String line;
            int lineCount = 0;
            
            // 처음 10줄만 출력
            System.out.println("파일의 처음 10줄:");
            while ((line = bufferedReader.readLine()) != null && lineCount < 10) {
                System.out.println((lineCount + 1) + ": " + line);
                lineCount++;
            }
            
            // 나머지 라인 개수 세기
            int remainingLines = 0;
            while (bufferedReader.readLine() != null) {
                remainingLines++;
            }
            
            System.out.println("... 외 " + remainingLines + "개 라인이 더 있습니다.");
            
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }
} 