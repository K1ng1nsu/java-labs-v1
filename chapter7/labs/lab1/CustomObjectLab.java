package chapter7.labs.lab1;

import java.util.*;

/**
 * Object 클래스의 메소드를 오버라이딩하는 실습
 * <p>
 * 이 실습에서는 Java의 Object 클래스에서 제공하는 기본 메소드를 오버라이딩하여
 * 커스텀 클래스의 동작을 정의하는 방법을 학습합니다.
 * - equals(): 객체의 동등성 비교
 * - hashCode(): 객체의 해시 코드 생성
 * - toString(): 객체의 문자열 표현
 */
public class CustomObjectLab {
    public static void main(String[] args) {
        // TODO: Book 객체를 세 개 생성하세요.
        // book1, book2는 동일한 ISBN을 가진 책
        // book3는 다른 ISBN을 가진 책
        Book book1 = new Book("1234","Java in practice","John",120);
        Book book2 = new Book("1234","Java in practice","John",150);
        Book book3 = new Book("12345","Java in practice 2nd e","John",150);


        // TODO: equals() 메소드 테스트
        // book1과 book2, book1과 book3, book1과 null, book1과 다른 타입 객체를 비교하세요.
        System.out.println("book1 book2 equals method "+book1.equals(book2));
        System.out.println("book1 book2 equals method "+book1.equals(book3));
        System.out.println("book1 null equals method "+book1.equals(null));
        System.out.println("book1 String equals method "+book1.equals("Java in practice 2nd e"));


        // TODO: toString() 메소드 테스트
        // 각 Book 객체의 toString() 메소드 호출 결과를 출력하세요.
        System.out.println("book1 toString() : "+book1);
        System.out.println("book2 toString() : "+book2);
        System.out.println("book3 toString() : "+book3);


        // TODO: hashCode() 메소드 테스트
        // 각 Book 객체의 해시코드를 출력하고, book1과 book2의 해시코드가 같은지 확인하세요.

        System.out.println("book1 hashCode() : "+book1.hashCode());
        System.out.println("book2 hashCode() : "+book2.hashCode());
        System.out.println("book3 hashCode() : "+book3.hashCode());

        System.out.println("book1 book2 hashCode()  ==  : "+(book1.hashCode() == book2.hashCode()));



        // TODO: HashMap에서 Book 객체를 키로 사용하는 예제 코드를 작성하세요.
        // 1. HashMap<Book, String> 생성
        // 2. book1과 book3를 키로 하여 값 저장
        // 3. book1, book2, book3로 값 조회 시도
        Map<Book, String> map = new HashMap<>();
        map.put(book1, "b1 value");
        map.put(book3, "b3 value");

        System.out.println("map get book1 : "+map.get(book1));
        System.out.println("map get book2 : "+map.get(book2));
        System.out.println("map get book3 : "+map.get(book3));




        // TODO: ArrayList에서 Book 객체의 존재 여부를 확인하는 예제 코드를 작성하세요.
        // 1. ArrayList<Book> 생성
        // 2. book1과 book3를 리스트에 추가
        // 3. book1, book2, book3가 리스트에 존재하는지 확인
        List<Book> list = new ArrayList<>();

        list.add(book1);
        list.add(book3);

        System.out.println("is book1 exist in list : "+list.contains(book1));
        System.out.println("is book2 exist in list : "+list.contains(book2));
        System.out.println("is book3 exist in list : "+list.contains(book3));



    }
}

/**
 * Object 클래스의 주요 메소드를 오버라이딩할 Book 클래스입니다.
 */
class Book {
    // TODO: ISBN, 제목, 저자, 가격 필드를 선언하세요.
    private String isbnCode;
    private String title;
    private String author;
    private int price;
    // TODO: 모든 필드를 초기화하는 생성자를 작성하세요.

    public Book(String isbnCode, String title, String author, int price) {
        this.isbnCode = isbnCode;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // TODO: 필요한 Getter 메소드를 작성하세요.

    public String getIsbnCode() {
        return isbnCode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }


    // TODO: equals() 메소드를 오버라이딩하여 ISBN이 같으면 동일한 책으로 판단하도록 구현하세요.
    // equals 메소드 구현 시 다음 사항을 고려하세요:
    // 1. 참조가 동일한지 확인 (this == obj)
    // 2. null 체크 및 타입 비교 (obj != null && getClass() == obj.getClass())
    // 3. 적절한 형변환 후 필드 비교

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getIsbnCode(), book.getIsbnCode());
    }

    // TODO: hashCode() 메소드를 오버라이딩하여 equals와 일관되게 동작하도록 구현하세요.
    // ISBN이 같은 객체는 동일한 해시코드를 반환해야 합니다.
    // java.util.Objects.hash() 메소드를 활용하세요.

    @Override
    public int hashCode() {
        return Objects.hash(getIsbnCode());
    }
    // TODO: toString() 메소드를 오버라이딩하여 Book 객체의 모든 필드 정보를 포함한 문자열을 반환하세요.

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbnCode + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}