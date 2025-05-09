package chapter7.labs.lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 텍스트 파일을 생성하고 처리하는 실습
 * <p>
 * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
 * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
 */
public class TextFileIOLab {
    // 파일 경로 상수
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";

    public static void main(String[] args) {
        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.

        Scanner sc = new Scanner(System.in);

        // TODO: 프로그램 메인 루프를 구현하세요.
        // 1. showMenu() 메소드를 호출하여 메뉴 표시
        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
        //    - 1: createTextFile()
        //    - 2: readTextFile()
        //    - 3: searchTextInFile()
        //    - 4: replaceTextInFile()
        //    - 5: countFileStats()
        //    - 6: appendToFile()
        //    - 7: 프로그램 종료
        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력

        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int userInput = getIntInput(sc, 1, 7);

            switch (userInput) {
                case 1:
                    createTextFile(sc);
                    break;
                case 2:
                    readTextFile();
                    break;
                case 3:
                    searchTextInFile(sc);
                    break;
                case 4:
                    replaceTextInFile(sc);
                    break;
                case 5:
                    countFileStats();
                    break;
                case 6:
                    appendToFile(sc);
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                    break;
            }

        }


    }

    /**
     * 메뉴 출력
     */
    private static void showMenu() {
        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
        // 1. 텍스트 파일 생성하기
        // 2. 텍스트 파일 읽기
        // 3. 텍스트 파일에서 검색하기
        // 4. 텍스트 파일에서 문자열 치환하기
        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
        // 6. 파일에 내용 추가하기
        // 7. 종료
        System.out.println("### 프로그램 메뉴 ###");
        System.out.println("1. 텍스트 파일 생성하기");
        System.out.println("2. 텍스트 파일 읽기");
        System.out.println("3. 텍스트 파일에서 검색하기");
        System.out.println("4. 텍스트 파일에서 문자열 치환하기");
        System.out.println("5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)");
        System.out.println("6. 파일에 내용 추가하기");
        System.out.println("7. 종료");
    }

    /**
     * 사용자로부터 정수 입력 받기
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
        // 1. 사용자 입력을 정수로 변환 시도
        // 2. 입력값이 min과 max 사이의 값인지 확인
        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
        // 4. 유효한 입력을 받을 때까지 반복
        int input;
        do {
            System.out.print("1 ~ 7 까지의 번호를 입력해주세요 : ");
            input = Integer.parseInt(scanner.nextLine());

            if (input >= min && input <= max) {
                break;
            }

            System.out.println("잘못된 입력입니다.");
        } while (true);

        return input; // 구현 후 이 줄을 수정하세요.
    }

    /**
     * 텍스트 파일 생성
     */
    private static void createTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일 생성하기");

        // TODO: 파일이 이미 존재하는지 확인하세요.
        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
        // 3. 사용자가 'n'을 입력하면 메소드 종료

        File file = new File(FILE_PATH);
        boolean isExist = file.exists();

        if (isExist) {
            System.out.print("파일이 이미 존재합니다. 덮어쓰시겠습니까? y/n : ");

            String input;

            do {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                    break;
                }

                System.out.print("잘못된 입력입니다. 다시 입력해주세요. y/n :");
            } while (true);

            if (input.equalsIgnoreCase("n")) {
                System.out.println("텍스트 파일 생성을 종료합니다.");
                return;
            }


        }

        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        String inputText;
        int lineNum = 1;
        List<String> lines = new ArrayList<>();
        System.out.println("빈 줄을 입력하면 입력을 종료합니다.");
        do {
            System.out.print("입력할 내용 : ");
            inputText = scanner.nextLine();

            if (inputText.trim().isEmpty()) {
                break;
            }

            lines.add("ln" + lineNum+" :" +inputText );
            lineNum++;

        } while (true);

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter와 BufferedWriter 생성
        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
        // 4. 예외 처리 및 성공 메시지 출력

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bw.write(line + "\n");
            }
            System.out.println("성공적으로 파일을 저장했습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }
    }

    /**
     * 텍스트 파일 읽기
     */
    private static void readTextFile() {
        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일 읽기");

        File file = new File(FILE_PATH);

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        boolean isExist = file.exists();
        if (!isExist) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }


        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileReader와 BufferedReader 생성
        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
        // 4. 각 줄 앞에 줄 번호 붙여서 출력
        // 5. 예외 처리 및 완료 메시지 출력
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine()).append("\n");
            }
            System.out.println(sb);
            System.out.println("출력이 완료되었습니다.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }


    }

    /**
     * 텍스트 파일에서 문자열 검색
     */
    private static void searchTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일에서 검색하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        boolean isExist = file.exists();
        if (!isExist) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }

        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.
        System.out.print("검색할 텍스트를 입력해주세요. : ");
        String inputText = scanner.nextLine();

        System.out.print("대소문자를 구분하겠습니까? y/n : ");
        String strIgnore;
        do {
            strIgnore = scanner.nextLine();
            if (strIgnore.equalsIgnoreCase("y") || strIgnore.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("잘못된 입력입니다. 대소문자를 구분하겠습니까? y/n : ");
        } while (true);

        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
        // 1. try-with-resources 구문 사용
        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
        // 6. 예외 처리

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            int count = 0;

            if (strIgnore.equalsIgnoreCase("y")) {
                // when user choose y - Case-Sensitive
                while (br.ready()) {
                    String line = br.readLine();

                    if (line.contains(inputText)) {
                        String[] words = line.split(" ");

                        for (int i = 0; i < words.length; i++) {
                            if (words[i].contains(inputText)) {
                                words[i] = "*"+inputText+"*";
                                count++;
                            }
                        }

                        sb.append(changeStrArrayToString(words)).append("\n");
                    }
                }
            } else {
                // when user choose n
                while (br.ready()) {
                    String line = br.readLine();

                    if (line.toLowerCase().contains(inputText.toLowerCase())) {
                        String[] words = line.split(" ");

                        for (int i = 0; i < words.length; i++) {
                            if (words[i].toLowerCase().contains(inputText.toLowerCase())) {
                                words[i] = "*"+inputText+"*";
                                count++;
                            }
                        }

                        sb.append(changeStrArrayToString(words)).append("\n");
                    }
                }

            }

            System.out.println(sb);
            System.out.println("일치한 텍스트 개수 : " + count);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }


    }

    /**
     * 텍스트 파일에서 문자열 치환
     */
    private static void replaceTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일에서 문자열 치환하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        boolean isExist = file.exists();
        if (!isExist) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }

        // TODO: 사용자로부터 다음 정보를 입력받으세요:
        // 1. 찾을 텍스트
        // 2. 변경할 텍스트
        // 3. 대소문자 구분 여부 (y/n)
        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)
        System.out.print("변경하실 문자열을 입력해주세요. : ");
        String targetText = scanner.nextLine();

        System.out.print("무엇으로 변경되어야 하나요? : ");
        String replacement = scanner.nextLine();

        System.out.print("대소문자 구분여부 y/n : ");
        String strIgnore;
        do {
            strIgnore = scanner.nextLine();
            if (strIgnore.equalsIgnoreCase("y") || strIgnore.equalsIgnoreCase("n")) {
                break;
            }
            System.out.print("잘못된 입력입니다. 대소문자 구분여부 y/n : ");
        } while (true);


        String strIsAllReplace;
        System.out.print("각 줄의 모든 문자열이 변경되어야 합니까? y/n : ");

        do {
            strIsAllReplace = scanner.nextLine();
            if (strIsAllReplace.equalsIgnoreCase("y") || strIsAllReplace.equalsIgnoreCase("n")) {
                break;
            }
            System.out.println("잘못된 입력입니다. 각 줄의 모든 문자열이 변경되어야 합니까? y/n : ");
        } while (true);


        // TODO: 파일 내용을 List<String>으로 읽어오세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장

        List<String> lines = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            if (br.ready()) {
                lines = br.lines().toList();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }

        if (lines == null) {
            System.out.println("비어있는 파일입니다");
            return;
        }

        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
        //    - String.replace() 또는 String.replaceAll()
        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
        // 2. 몇 개의 라인이 변경되었는지 카운트

        int changeLineNum = 0;
        int replaceKeywordNum = 0;

        List<String> replacedLines = new ArrayList<>();

        if (strIgnore.equalsIgnoreCase("y")) {
            // case-sensitive
            if (strIsAllReplace.equalsIgnoreCase("y")) {
                // replace all
                for (String line : lines) {

                    String[] words = line.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].equals(targetText)) {
                            words[i] = replacement;
                            replaceKeywordNum++;
                            // words changed
                        }
                    }
                    replacedLines.add(changeStrArrayToString(words));
                    changeLineNum++;
                }


            } else {
                // replace first
                for (String line : lines) {
                    String[] words = line.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].equals(targetText)) {
                            words[i] = replacement;
                            replaceKeywordNum++;
                            changeLineNum++;
                            break; // only a word changed
                        }
                    }
                    replacedLines.add(changeStrArrayToString(words));
                }
            }

        } else {
            // non-sensitive
            if (strIsAllReplace.equalsIgnoreCase("y")) {
                // replace all
                for (String line : lines) {
                    String[] words = line.split(" ");
                    if (line.toLowerCase().contains(targetText.toLowerCase())) {
                        for (int i = 0; i < words.length; i++) {
                            if (words[i].equalsIgnoreCase(targetText)) {
                                words[i] = replacement;
                                replaceKeywordNum++;
                                // words changed
                            }
                        }
                        changeLineNum++;
                    }
                    replacedLines.add(changeStrArrayToString(words));
                }

            } else {
                // replace first
                for (String line : lines) {
                    String[] words = line.split(" ");
                    if (line.toLowerCase().contains(targetText.toLowerCase())) {
                        for (int i = 0; i < words.length; i++) {
                            if (words[i].equalsIgnoreCase(targetText)) {
                                words[i] = replacement;
                                replaceKeywordNum++;
                                break; // only a word changed
                            }
                        }
                        changeLineNum++;
                    }
                    replacedLines.add(changeStrArrayToString(words));
                }

            }

        }

        // TODO: 변경된 내용을 파일에 다시 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
        // 3. 변경된 라인 수 출력
        // 4. 예외 처리

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : replacedLines) {
                bw.write(line + "\n");
            }
            System.out.println("성공적으로 변경되었습니다.");
            System.out.println("변경된 라인 수 : " + changeLineNum);
            System.out.println("변경된 텍스트 수: " + replaceKeywordNum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }


    }

    /**
     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
     */
    private static void countFileStats() {
        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.
        System.out.println("파일 통계 계산하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        boolean isExist = file.exists();
        if (!isExist) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }


        // TODO: 파일 통계를 계산하세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 파일 읽기
        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
        // 5. 문자 수 계산 (각 라인의 길이 합산)

        int lineNum = 0;
        int wordNum = 0;
        int charNum = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String line = br.readLine();
                lineNum++;
                charNum += line.length();
                wordNum += line.split(" ").length;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }

        // TODO: 계산된 통계 정보를 출력하세요.
        // 1. 라인 수
        // 2. 단어 수
        // 3. 문자 수
        // 4. 예외 처리
        System.out.println("lineNum: " + lineNum);
        System.out.println("wordNum: " + wordNum);
        System.out.println("charNum: " + charNum);
        //
    }

    /**
     * 파일에 내용 추가
     */
    private static void appendToFile(Scanner scanner) {
        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.
        System.out.println("파일에 내용 추가하기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File(FILE_PATH);
        boolean isExist = file.exists();
        if (!isExist) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }

        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        List<String> lines = new ArrayList<>();

        String line;
        do {
            line = scanner.nextLine();
            if (line != null && line.trim().isEmpty()) {
                break;
            }
            lines.add(line);
        } while (true);

        int lineNum = lines.size();
        int addLineNum = 0;

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
        // 3. 구분선("--- 추가된 내용 ---") 추가
        // 4. 리스트의 각 줄을 파일에 추가
        // 5. 예외 처리 및 성공 메시지 출력

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("--- 추가된 내용 ---\n");
            for (String s : lines) {
                lineNum++;
                bw.write("ln" + lineNum+" :"+s + "\n");
                addLineNum++;
            }

            System.out.println("성공적으로 내용을 추가했습니다. 추가된 라인 수: " + addLineNum);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("예외 발생 메소드를 종료합니다.");
            return;
        }

    }

    private static String changeStrArrayToString(String[] strArray) {
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    // - 개선 방안
    //   -- 가독성 및 유지 보수
    //   -- 중복 로직 제거
    // - 각 라인 넘버 제거하는 메소드 만들기
    // - 각 라인 넘버 추가하는 메소드 만들기
    // - y/n 입력 위임 메소드
    // - 긴 메소드 체인 제거 위임
    // - 배열순회 공통로직 제거

    //   -- 기능
    // - 라인 넘버를 셀 때 "--- 추가된 내용 ---" 제외하고 세기
    // - 현재 치환은 단어 단위로만 치환,  검색 부분의 로직 개선 요망
    // - 파일 통계 내, 라인넘버, 추가된내용 표식 등을 통계에서 제외해야함
    //

}