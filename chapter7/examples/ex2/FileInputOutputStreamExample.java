package chapter7.examples.ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 바이트 단위 파일 입출력의 기본 예제
 * FileInputStream과 FileOutputStream을 사용한 파일 복사 구현
 */
public class FileInputOutputStreamExample {
    public static void main(String[] args) {
        // 원본 파일과 대상 파일 경로 설정
        String sourceFile = "chapter7/examples/ex2/input.txt";
        String destinationFile = "chapter7/examples/ex2/output.txt";
        
        // 먼저 간단한 텍스트 파일 생성
        createSampleFile(sourceFile);
        
        // 파일 복사 수행
        copyFile(sourceFile, destinationFile);
        
        // 파일 내용 출력
        readAndPrintFile(destinationFile);
    }
    
    /**
     * 예제용 샘플 파일을 생성하는 메소드
     * 
     * @param fileName 생성할 파일 이름
     */
    private static void createSampleFile(String fileName) {
        // try-with-resources 구문으로 자원 자동 해제
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String content = "안녕하세요!\n자바 파일 입출력 예제입니다.\n"
                           + "FileInputStream과 FileOutputStream은\n"
                           + "바이트 단위로 데이터를 읽고 쓰는 클래스입니다.\n"
                           + "이 예제에서는 파일 복사 기능을 구현합니다.";
            
            // 문자열을 바이트 배열로 변환
            byte[] contentBytes = content.getBytes();
            
            // 파일에 바이트 배열 쓰기
            fos.write(contentBytes);
            System.out.println("샘플 파일이 생성되었습니다: " + fileName);
            
        } catch (IOException e) {
            System.err.println("파일 생성 중 오류 발생: " + e.getMessage());
        }
    }
    
    /**
     * 파일을 복사하는 메소드
     * 
     * @param sourceFile 원본 파일 경로
     * @param destFile 대상 파일 경로
     */
    private static void copyFile(String sourceFile, String destFile) {
        // try-with-resources 구문으로 입출력 스트림 자동 닫기
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            System.out.println("\n파일 복사를 시작합니다...");
            
            // 파일 읽기/쓰기에 사용할 버퍼
            byte[] buffer = new byte[1024]; // 1KB 버퍼
            int bytesRead;
            int totalBytesRead = 0;
            
            // 파일에서 데이터를 읽어 다른 파일에 쓰기
            long startTime = System.currentTimeMillis(); // 시간 측정 시작
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            
            long endTime = System.currentTimeMillis(); // 시간 측정 종료
            
            System.out.println("파일 복사가 완료되었습니다!");
            System.out.println("복사된 바이트 수: " + totalBytesRead + " bytes");
            System.out.println("소요 시간: " + (endTime - startTime) + "ms");
            
        } catch (IOException e) {
            System.err.println("파일 복사 중 오류 발생: " + e.getMessage());
        }
    }
    
    /**
     * 파일의 내용을 읽어서 콘솔에 출력하는 메소드
     * 
     * @param fileName 읽을 파일 이름
     */
    private static void readAndPrintFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            System.out.println("\n=== 파일 내용 ===");
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                // 바이트 배열을 문자열로 변환하여 출력
                String content = new String(buffer, 0, bytesRead);
                System.out.print(content);
            }
            
            System.out.println("\n=== 파일 끝 ===");
            
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }
} 