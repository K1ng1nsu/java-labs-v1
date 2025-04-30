package chapter4.examples.ex2;

/**
 * 다양한 생성자 활용 예제
 * Book 클래스 정의
 */
public class Book {
    // 필드
    String title;       // 제목
    String author;      // 저자
    int price;          // 가격
    int publishYear;    // 출판연도
    
    // 기본 생성자
    public Book() {
        System.out.println("Book 객체가 생성되었습니다. (기본 생성자)");
        this.title = "제목 없음";
        this.author = "저자 미상";
        this.price = 0;
        this.publishYear = 2023;
    }
    
    // 제목만 받는 생성자
    public Book(String title) {
        this(title, "저자 미상", 0, 2023);
    }
    
    // 제목과 저자를 받는 생성자
    public Book(String title, String author) {
        this(title, author, 0, 2023);
    }
    
    // 제목, 저자, 가격을 받는 생성자
    public Book(String title, String author, int price) {
        this(title, author, price, 2023);
    }
    
    // 모든 필드를 초기화하는 생성자
    public Book(String title, String author, int price, int publishYear) {
        System.out.println("Book 객체가 생성되었습니다. (매개변수 4개 생성자)");
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishYear = publishYear;
    }
    
    // 책 정보 출력 메소드
    public void displayInfo() {
        System.out.println("===== 책 정보 =====");
        System.out.println("제목: " + title);
        System.out.println("저자: " + author);
        System.out.println("가격: " + price + "원");
        System.out.println("출판연도: " + publishYear + "년");
        System.out.println("==================");
    }
} 