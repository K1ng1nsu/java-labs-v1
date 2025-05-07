package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * <p>
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    private ArrayList<Buyable> products;


    // TODO: 생성자 정의

    public ShoppingCart() {
    }

    public ShoppingCart(ArrayList<Buyable> products) {
        this.products = products;
    }

    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addProduct(Buyable product) {
        products.add(product);
    }

    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeProduct(Buyable product) {
        products.remove(product);
    }

    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Buyable product : products) {
            if (product instanceof Discountable) {
                Discountable discountable = (Discountable) product;
                totalPrice += discountable.getDiscountedPrice();
            } else {

                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printProducts() {
        for (Buyable product : products) {
            if (product instanceof Discountable) {
                Discountable discountable = (Discountable) product;
                System.out.println(discountable);
            }else{
                System.out.println(product);
            }
        }
    }

} 