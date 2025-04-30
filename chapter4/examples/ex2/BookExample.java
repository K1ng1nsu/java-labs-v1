package chapter4.examples.ex2;

/**
 * Book 클래스의 다양한 생성자를 활용하는 예제
 */
public class BookExample {
    public static void main(String[] args) {
        // 기본 생성자를 이용한 객체 생성
        Book book1 = new Book();
        book1.displayInfo();
        System.out.println();
        
        // 제목만 받는 생성자를 이용한 객체 생성
        Book book2 = new Book("Java Programming");
        book2.displayInfo();
        System.out.println();
        
        // 제목과 저자를 받는 생성자를 이용한 객체 생성
        Book book3 = new Book("Database Basics", "Charles");
        book3.displayInfo();
        System.out.println();
        
        // 제목, 저자, 가격을 받는 생성자를 이용한 객체 생성
        Book book4 = new Book("Understanding Algorithms", "Sarah", 25000);
        book4.displayInfo();
        System.out.println();
        
        // 모든 필드를 초기화하는 생성자를 이용한 객체 생성
        Book book5 = new Book("Cloud Computing", "Matthew", 30000, 2022);
        book5.displayInfo();
        System.out.println();
        
        // 객체 생성 후 필드 값 변경
        Book book6 = new Book("Initial Title", "Initial Author");
        book6.title = "Changed Title";
        book6.author = "Changed Author";
        book6.price = 15000;
        book6.publishYear = 2024;
        book6.displayInfo();
    }
} 