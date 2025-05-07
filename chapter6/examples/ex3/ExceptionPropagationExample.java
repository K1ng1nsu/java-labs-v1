package chapter6.examples.ex3;

/**
 * 예외 던지기 및 전파 예제
 * 
 * 이 예제는 메소드 체인을 통해 예외가 어떻게 전파되는지 보여줍니다.
 * throws 키워드를 사용한 예외 선언과 예외 전파 과정을 이해할 수 있습니다.
 */
public class ExceptionPropagationExample {
    public static void main(String[] args) {
        System.out.println("=== 예외 던지기 및 전파 예제 ===");
        
        try {
            // 메소드 체인 시작
            methodA();
            System.out.println("이 코드는 실행되지 않습니다.");
        } catch (Exception e) {
            System.out.println("main에서 예외를 잡았습니다: " + e.getMessage());
            
            // 스택 추적 정보 출력
            System.out.println("\n예외 발생 위치 추적:");
            e.printStackTrace();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        
        System.out.println("\n=== checked 예외와 unchecked 예외 ===");
        
        // Checked 예외 (컴파일러가 처리를 강제함)
        try {
            throwCheckedException();
        } catch (Exception e) {
            System.out.println("Checked 예외를 처리했습니다: " + e.getMessage());
        }
        
        // Unchecked 예외 (컴파일러가 처리를 강제하지 않음)
        try {
            throwUncheckedException();
        } catch (RuntimeException e) {
            System.out.println("Unchecked 예외를 처리했습니다: " + e.getMessage());
        }
        
        System.out.println("\n=== 다중 메소드를 통한 예외 전파 ===");
        try {
            processData("");
        } catch (IllegalArgumentException e) {
            System.out.println("입력 데이터 오류: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("실행 시간 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("일반 오류: " + e.getMessage());
        }
    }
    
    // 메소드 체인의 시작
    public static void methodA() throws Exception {
        System.out.println("methodA 실행");
        methodB();
        System.out.println("methodA 종료"); // 실행되지 않음
    }
    
    // 두 번째 메소드
    private static void methodB() throws Exception {
        System.out.println("methodB 실행");
        methodC();
        System.out.println("methodB 종료"); // 실행되지 않음
    }
    
    // 세 번째 메소드 - 예외 발생
    private static void methodC() throws Exception {
        System.out.println("methodC 실행");
        
        // 예외 발생
        throw new Exception("methodC에서 고의로 발생시킨 예외");
        
        // 이 코드는 실행되지 않음
        // System.out.println("methodC 종료");
    }
    
    // checked 예외를 발생시키는 메소드
    private static void throwCheckedException() throws Exception {
        throw new Exception("이것은 checked 예외입니다.");
    }
    
    // unchecked 예외를 발생시키는 메소드
    private static void throwUncheckedException() {
        throw new RuntimeException("이것은 unchecked 예외입니다.");
    }
    
    // 데이터 처리 메소드 체인
    private static void processData(String data) throws Exception {
        validateData(data);
        transformData(data);
        saveData(data);
        System.out.println("데이터 처리 완료: " + data);
    }
    
    private static void validateData(String data) {
        if (data == null) {
            throw new IllegalArgumentException("데이터가 null입니다.");
        }
        
        if (data.isEmpty()) {
            throw new IllegalArgumentException("데이터가 비어 있습니다.");
        }
    }
    
    private static void transformData(String data) {
        // 데이터 변환 로직 (예외 발생 가능)
        System.out.println("데이터 변환 중: " + data);
    }
    
    private static void saveData(String data) throws Exception {
        // 데이터 저장 로직 (예외 발생 가능)
        if (Math.random() < 0.1) {
            throw new Exception("데이터 저장 중 오류 발생");
        }
        System.out.println("데이터 저장 완료");
    }
} 