package chapter8.labs.lab2;

import java.util.*;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 * <p>
 * 도서 관리 시스템의 주요 기능을 구현한 클래스입니다.
 */
public class LibraryManager {
    // 도서 목록 (ArrayList 활용)
    private List<Book> books;

    // 사용자별 대여 현황 (HashMap 활용)
    private Map<String, List<Book>> userBorrowMap;

    // 도서 카테고리 (HashSet 활용)
    private Set<String> categories;

    /**
     * 생성자
     */
    public LibraryManager(List<Book> books, Map<String, List<Book>> userBorrowMap, Set<String> categories) {
        // TODO: 필드를 초기화하세요.
        this.books = books;
        this.userBorrowMap = userBorrowMap;
        this.categories = categories;
    }

    /**
     * 도서 추가 메소드
     */
    public void addBook(Book book) {
        // TODO: 도서를 추가하고, 카테고리도 Set에 추가하세요.
        books.add(book);
        categories.add(book.getCategory());
    }

    /**
     * 도서 검색 메소드 (제목으로 검색)
     */
    public List<Book> searchBooksByTitle(String title) {
        // TODO: 제목에 검색어가 포함된 도서를 검색하세요.
        List<Book> searchedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    /**
     * 도서 검색 메소드 (저자로 검색)
     */
    public List<Book> searchBooksByAuthor(String author) {
        // TODO: 저자명으로 도서를 검색하세요.
        List<Book> searchedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    /**
     * 도서 대여 메소드
     */
    public boolean borrowBook(String userId, String isbn) {
        // TODO: 도서를 대여하고, 사용자별 대여 현황을 업데이트하세요.
        boolean isUserBorrowed = userBorrowMap.containsKey(userId);

        List<Book> borrowedBooks;
        if (isUserBorrowed) {
            borrowedBooks = userBorrowMap.get(userId);
        } else {
            borrowedBooks = new ArrayList<>();
        }

        Book wantToBorrow = getBookByIsbn(books, isbn);
        boolean isSuccess = wantToBorrow != null;

        borrowedBooks.add(getBookByIsbn(books, isbn));
        userBorrowMap.put(userId, borrowedBooks);


        return isSuccess;
    }

    /**
     * 도서 반납 메소드
     */
    public boolean returnBook(String userId, String isbn) {
        // TODO: 도서를 반납하고, 사용자별 대여 현황을 업데이트하세요.
        boolean isUserBorrowed = userBorrowMap.containsKey(userId);
        List<Book> borrowedBooks;
        if (isUserBorrowed) {
            borrowedBooks = userBorrowMap.get(userId);
        } else {
            return false;
        }

        int indexOfBook = borrowedBooks.indexOf(getBookByIsbn(books, isbn));

        Book borrowedBook = borrowedBooks.get(indexOfBook);
        borrowedBooks.remove(borrowedBook);

        books.add(borrowedBook);


        return true;
    }

    /**
     * 사용자의 대여 도서 목록 조회 메소드
     */
    public List<Book> getBorrowedBooks(String userId) {
        // TODO: 사용자가 대여한 도서 목록을 반환하세요.
        return userBorrowMap.get(userId);
    }

    /**
     * 도서 정렬 메소드 (제목 기준)
     */
    public List<Book> getSortedBooksByTitle() {
        // TODO: 제목 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> copiedBooks = new ArrayList<>(books.stream().toList());
        copiedBooks.sort((book1, book2) -> book1.getTitle().compareTo(book2.getTitle()));
        return copiedBooks;
    }

    /**
     * 도서 정렬 메소드 (출판년도 기준)
     */
    public List<Book> getSortedBooksByYear() {
        // TODO: 출판년도 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> copiedBooks = new ArrayList<>(books);
        copiedBooks.sort((book1, book2) -> Integer.compare(book1.getPublicationYear(), book2.getPublicationYear()));
        return copiedBooks;
    }

    /**
     * 도서 정렬 메소드 (가격 기준)
     */
    public List<Book> getSortedBooksByPrice() {
        // TODO: 가격 기준으로 정렬된 도서 목록을 반환하세요.
        List<Book> copiedBooks = new ArrayList<>(books);
        copiedBooks.sort((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice()));
        return copiedBooks;
    }

    /**
     * 카테고리 목록 조회 메소드
     */
    public Set<String> getCategories() {
        // TODO: 모든 카테고리를 반환하세요.
        if (categories == null) return null;
        return new HashSet<>(categories.stream().toList());
    }

    /**
     * 카테고리별 도서 목록 조회 메소드
     */
    public List<Book> getBooksByCategory(String category) {
        // TODO: 특정 카테고리에 속한 도서 목록을 반환하세요.
        List<Book> specificBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equals(category)) {
                specificBooks.add(book);
            }
        }
        return specificBooks;
    }

    /**
     * 전체 도서 목록 조회 메소드
     */
    public List<Book> getAllBooks() {
        // TODO: 전체 도서 목록을 반환하세요.
        return new ArrayList<>(books);
    }

    public static Book getBookByIsbn(List<Book> books, String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

} 