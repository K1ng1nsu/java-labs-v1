package chapter8.labs.lab2;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템에서 사용할 도서 클래스입니다.
 */
public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int publicationYear;
    private double price;
    
    /**
     * 생성자
     */
    public Book(String isbn, String title, String author, String category, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
        this.price = price;
    }
    
    // TODO: getter와 setter 메소드를 구현하세요.
    
    
    // TODO: toString 메소드를 오버라이드하세요.
    
    
    // TODO: equals 메소드를 오버라이드하세요.
    
    
    // TODO: hashCode 메소드를 오버라이드하세요.
    
    
    /**
     * Comparable 인터페이스의 compareTo 메소드 구현
     * 기본적으로 ISBN 기준으로 비교합니다.
     */
    @Override
    public int compareTo(Book other) {
        // TODO: ISBN 기준으로 비교하도록 구현하세요.
        return 0;
    }
} 