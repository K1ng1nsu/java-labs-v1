package chapter7.examples.ex1;

/**
 * Object 클래스의 주요 메소드를 구현하고 활용하는 예제
 */
public class ObjectClassExample {
    public static void main(String[] args) {
        // 두 개의 동일한 내용을 가진 Product 객체 생성
        Product product1 = new Product("노트북", 1500000, "전자제품");
        Product product2 = new Product("노트북", 1500000, "전자제품");
        
        // 서로 다른 내용을 가진 Product 객체 생성
        Product product3 = new Product("스마트폰", 1200000, "전자제품");
        
        // 동일한 참조인지 비교 (==)
        System.out.println("=== 참조 비교 (==) ===");
        System.out.println("product1 == product2: " + (product1 == product2));
        System.out.println("product1 == product3: " + (product1 == product3));
        
        // equals() 메소드를 사용한 내용 비교
        System.out.println("\n=== 내용 비교 (equals) ===");
        System.out.println("product1.equals(product2): " + product1.equals(product2));
        System.out.println("product1.equals(product3): " + product1.equals(product3));
        
        // hashCode() 메소드 결과 확인
        System.out.println("\n=== hashCode 비교 ===");
        System.out.println("product1 hashCode: " + product1.hashCode());
        System.out.println("product2 hashCode: " + product2.hashCode());
        System.out.println("product3 hashCode: " + product3.hashCode());
        
        // toString() 메소드 결과 확인
        System.out.println("\n=== toString 메소드 ===");
        System.out.println("product1.toString(): " + product1.toString());
        System.out.println("product2: " + product2); // toString() 자동 호출
        System.out.println("product3: " + product3);
        
        // getClass() 메소드 활용
        System.out.println("\n=== getClass 메소드 ===");
        System.out.println("product1의 클래스: " + product1.getClass().getName());
        System.out.println("product1의 슈퍼클래스: " + product1.getClass().getSuperclass().getName());
        
        // clone() 메소드 사용 예
        try {
            System.out.println("\n=== clone 메소드 ===");
            CloneableProduct cloneableProduct = new CloneableProduct("태블릿", 800000, "전자제품");
            CloneableProduct clonedProduct = (CloneableProduct) cloneableProduct.clone();
            
            System.out.println("원본 객체: " + cloneableProduct);
            System.out.println("복제 객체: " + clonedProduct);
            System.out.println("원본 == 복제본: " + (cloneableProduct == clonedProduct));
            System.out.println("원본.equals(복제본): " + cloneableProduct.equals(clonedProduct));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        // finalize() 메소드
        System.out.println("\n=== finalize 메소드 ===");
        System.out.println("finalize 메소드는 자바 9부터 deprecated되었습니다.");
        System.out.println("자원 해제는 try-with-resources 또는 명시적인 close() 메소드 호출을 권장합니다.");
    }
}

/**
 * Object 클래스의 주요 메소드를 오버라이드하는 제품 클래스
 */
class Product {
    private String name;
    private int price;
    private String category;
    
    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    // equals() 메소드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Product other = (Product) obj;
        return price == other.price && 
               name.equals(other.name) && 
               category.equals(other.category);
    }
    
    // hashCode() 메소드 오버라이드
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        result = 31 * result + category.hashCode();
        return result;
    }
    
    // toString() 메소드 오버라이드
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}

/**
 * Cloneable 인터페이스를 구현하는 제품 클래스
 */
class CloneableProduct extends Product implements Cloneable {
    public CloneableProduct(String name, int price, String category) {
        super(name, price, category);
    }
    
    // clone() 메소드 오버라이드
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
} 