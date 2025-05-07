package chapter7.examples.ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 바이너리 데이터 처리 예제
 * DataInputStream과 DataOutputStream을 사용한 기본 타입 데이터 입출력
 */
public class BinaryFileExample {
    public static void main(String[] args) {
        String dataFile = "chapter7/examples/ex2/data.bin";
        
        // 바이너리 파일에 데이터 쓰기
        writeBinaryData(dataFile);
        
        // 바이너리 파일에서 데이터 읽기
        readBinaryData(dataFile);
    }
    
    /**
     * 바이너리 파일에 여러 데이터 타입을 기록하는 메소드
     * 
     * @param fileName 데이터를 기록할 파일 이름
     */
    private static void writeBinaryData(String fileName) {
        try (
            // 기본 파일 출력 스트림 생성
            FileOutputStream fos = new FileOutputStream(fileName);
            
            // 기본 타입 데이터를 쓸 수 있는 DataOutputStream으로 감싸기
            DataOutputStream dos = new DataOutputStream(fos)
        ) {
            System.out.println("바이너리 파일에 데이터 쓰기 시작...");
            
            // 다양한 데이터 타입 쓰기
            dos.writeInt(12345);           // 정수
            dos.writeDouble(3.14159);      // 실수
            dos.writeBoolean(true);        // 불리언
            dos.writeUTF("안녕하세요!");    // 문자열 (UTF-8 인코딩)
            
            // 배열 데이터 쓰기
            int[] numbers = {10, 20, 30, 40, 50};
            
            // 배열 길이 먼저 쓰기
            dos.writeInt(numbers.length);
            
            // 배열 요소 쓰기
            for (int number : numbers) {
                dos.writeInt(number);
            }
            
            System.out.println("데이터 쓰기 완료!");
            
        } catch (IOException e) {
            System.err.println("데이터 쓰기 중 오류 발생: " + e.getMessage());
        }
    }
    
    /**
     * 바이너리 파일에서 데이터를 읽는 메소드
     * 
     * @param fileName 데이터를 읽을 파일 이름
     */
    private static void readBinaryData(String fileName) {
        try (
            // 기본 파일 입력 스트림 생성
            FileInputStream fis = new FileInputStream(fileName);
            
            // 기본 타입 데이터를 읽을 수 있는 DataInputStream으로 감싸기
            DataInputStream dis = new DataInputStream(fis)
        ) {
            System.out.println("\n바이너리 파일에서 데이터 읽기 시작...");
            
            // 데이터를 쓴 순서와 동일한 순서로 읽어야 함
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            
            System.out.println("정수 값: " + intValue);
            System.out.println("실수 값: " + doubleValue);
            System.out.println("불리언 값: " + booleanValue);
            System.out.println("문자열 값: " + stringValue);
            
            // 배열 데이터 읽기
            int arrayLength = dis.readInt();
            int[] readNumbers = new int[arrayLength];
            
            System.out.println("\n배열 데이터 (길이: " + arrayLength + "):");
            for (int i = 0; i < arrayLength; i++) {
                readNumbers[i] = dis.readInt();
                System.out.println("배열[" + i + "] = " + readNumbers[i]);
            }
            
            System.out.println("데이터 읽기 완료!");
            
        } catch (IOException e) {
            System.err.println("데이터 읽기 중 오류 발생: " + e.getMessage());
        }
    }
} 