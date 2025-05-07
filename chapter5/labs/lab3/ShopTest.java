package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Book book = new Book("The Java Programing in Action","James",25);
        
        
        // TODO: Electronics 객체 생성
        Electronics electronics = new Electronics("phone",450,"Samsung");
        
        // TODO: DiscountedBook 객체 생성
        DiscountedBook discountedBook = new DiscountedBook("Effective Java","Jane",30,0.7);
        
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart shoppingCart = new ShoppingCart();
        
        // TODO: 장바구니에 상품 추가하기
        shoppingCart.addProduct(book);
        shoppingCart.addProduct(discountedBook);
        shoppingCart.addProduct(electronics);
        
        
        // TODO: 장바구니 내용과 총액 출력하기
        shoppingCart.printProducts();
        double totalPrice = shoppingCart.getTotalPrice();
        System.out.println("total price: $" + totalPrice);
        

        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        Buyable[] buyables = {book, discountedBook, electronics};

        for (Buyable buyable : buyables) {
            System.out.println(buyable);
        }
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        Discountable[] discountables = {discountedBook};
        for (Discountable discountable : discountables) {
            System.out.println(discountable);
        }
    }
} 