package chapter4.labs.lab2;

/**
 * Lab 2: 생성자 활용하기
 * 
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");
        
        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b1 = new Book();

        System.out.println(b1);
        
        
        
        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b2 = new Book("Jump to Java");

        System.out.println(b2);
        
        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b3 = new Book("Java for Beginners","John Doe");

        System.out.println(b3);
        
        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b4 = new Book("Java for Professionals","Jane Doe",40);

        System.out.println(b4);
        
        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book b5 = new Book("How to build concrete System", "William Henry",50,2006);

        System.out.println(b5);
        
        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        Book b6 = new Book("You can be the Best in the Worlds","Scam John",1000,2025);

        b6.title = "Sorry, Help yourself";
        System.out.println(b6);


        
    }
} 