package chapter8.labs.lab2;

import java.util.List;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 *
 * 도서 관리 시스템의 기능을 테스트하는 클래스입니다.
 */
public class LibraryTest {
    public static void main(String[] args) {
        // LibraryManager 객체 생성
        LibraryManager manager = new LibraryManager();
        
        // 테스트용 도서 데이터 추가
        addTestBooks(manager);
        
        // 전체 도서 목록 출력
        System.out.println("=== 전체 도서 목록 ===");
        printBookList(manager.getAllBooks());
        
        // 도서 검색 테스트
        System.out.println("\n=== '자바'가 제목에 포함된 도서 ===");
        printBookList(manager.searchBooksByTitle("자바"));
        
        System.out.println("\n=== '김'으로 시작하는 저자의 도서 ===");
        printBookList(manager.searchBooksByAuthor("김"));
        
        // 도서 정렬 테스트
        System.out.println("\n=== 제목 기준 정렬 ===");
        printBookList(manager.getSortedBooksByTitle());
        
        System.out.println("\n=== 출판년도 기준 정렬 ===");
        printBookList(manager.getSortedBooksByYear());
        
        System.out.println("\n=== 가격 기준 정렬 ===");
        printBookList(manager.getSortedBooksByPrice());
        
        // 카테고리 테스트
        System.out.println("\n=== 모든 카테고리 ===");
        System.out.println(manager.getCategories());
        
        System.out.println("\n=== 프로그래밍 카테고리 도서 ===");
        printBookList(manager.getBooksByCategory("프로그래밍"));
        
        // 도서 대여 테스트
        String userId = "user001";
        System.out.println("\n=== 도서 대여 테스트 ===");
        String isbnToBorrow = "9788960777330";
        boolean borrowed = manager.borrowBook(userId, isbnToBorrow);
        System.out.println("도서 대여 결과: " + (borrowed ? "성공" : "실패"));
        
        System.out.println("\n=== 사용자 대여 도서 목록 ===");
        printBookList(manager.getBorrowedBooks(userId));
        
        // 도서 반납 테스트
        System.out.println("\n=== 도서 반납 테스트 ===");
        boolean returned = manager.returnBook(userId, isbnToBorrow);
        System.out.println("도서 반납 결과: " + (returned ? "성공" : "실패"));
        
        System.out.println("\n=== 반납 후 사용자 대여 도서 목록 ===");
        printBookList(manager.getBorrowedBooks(userId));
    }
    
    /**
     * 테스트용 도서 데이터 추가 메소드
     */
    private static void addTestBooks(LibraryManager manager) {
        manager.addBook(new Book("9788960777330", "자바 프로그래밍", "홍작가", "프로그래밍", 2021, 30000));
        manager.addBook(new Book("9788960777347", "파이썬 기초", "김작가", "프로그래밍", 2020, 25000));
        manager.addBook(new Book("9788960777354", "알고리즘 개론", "이작가", "컴퓨터과학", 2019, 35000));
        manager.addBook(new Book("9788960777361", "자바스크립트 완벽 가이드", "박작가", "프로그래밍", 2022, 28000));
        manager.addBook(new Book("9788960777378", "인공지능 입문", "정지원", "컴퓨터과학", 2021, 40000));
        manager.addBook(new Book("9788960777385", "데이터베이스 시스템", "김작가", "컴퓨터과학", 2018, 32000));
        manager.addBook(new Book("9788960777392", "웹 개발의 정석", "이작가", "프로그래밍", 2023, 27000));
        manager.addBook(new Book("9788960777408", "리눅스 프로그래밍", "한작가", "프로그래밍", 2020, 26000));
        manager.addBook(new Book("9788960777415", "네트워크 보안", "김작가", "컴퓨터네트워크", 2022, 38000));
        manager.addBook(new Book("9788960777422", "클라우드 컴퓨팅", "정작가", "컴퓨터시스템", 2021, 36000));
    }
    
    /**
     * 도서 목록 출력 메소드
     */
    private static void printBookList(List<Book> books) {
        if (books == null || books.isEmpty()) {
            System.out.println("도서가 없습니다.");
            return;
        }
        
        for (Book book : books) {
            System.out.println(book);
        }
    }
} 