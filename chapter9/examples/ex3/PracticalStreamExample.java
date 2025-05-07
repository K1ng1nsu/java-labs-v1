package chapter9.examples.ex3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 실용적인 람다와 스트림 활용 예제
 * 
 * 이 예제에서는 실제 응용 사례에서 람다와 스트림을 활용하는 방법을 보여줍니다.
 */
public class PracticalStreamExample {

    // 상품 클래스 정의
    static class Product {
        private String name;
        private String category;
        private double price;
        private LocalDate registrationDate;
        
        public Product(String name, String category, double price, LocalDate registrationDate) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.registrationDate = registrationDate;
        }
        
        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
        public LocalDate getRegistrationDate() { return registrationDate; }
        
        @Override
        public String toString() {
            return name + " (" + category + ", " + price + "원, " + registrationDate + ")";
        }
    }
    
    public static void main(String[] args) {
        // 샘플 상품 데이터 생성
        List<Product> products = Arrays.asList(
            new Product("노트북", "전자기기", 1200000, LocalDate.of(2023, 5, 15)),
            new Product("스마트폰", "전자기기", 800000, LocalDate.of(2023, 3, 10)),
            new Product("이어폰", "액세서리", 150000, LocalDate.of(2023, 7, 1)),
            new Product("키보드", "주변기기", 120000, LocalDate.of(2023, 6, 20)),
            new Product("마우스", "주변기기", 50000, LocalDate.of(2023, 4, 15)),
            new Product("모니터", "전자기기", 350000, LocalDate.of(2023, 2, 10)),
            new Product("충전기", "액세서리", 35000, LocalDate.of(2023, 8, 5))
        );
        
        System.out.println("===== 실용적인 스트림 활용 예제 =====");
        
        // 1. 카테고리별 제품 수 계산
        System.out.println("카테고리별 제품 수:");
        Map<String, Long> categoryCount = products.stream()
                                                .collect(Collectors.groupingBy(
                                                    Product::getCategory,
                                                    Collectors.counting()
                                                ));
        categoryCount.forEach((category, count) -> 
            System.out.println(category + ": " + count + "개")
        );
        
        // 2. 카테고리별 평균 가격 계산
        System.out.println("\n카테고리별 평균 가격:");
        Map<String, Double> categoryAvgPrice = products.stream()
                                                     .collect(Collectors.groupingBy(
                                                         Product::getCategory,
                                                         Collectors.averagingDouble(Product::getPrice)
                                                     ));
        categoryAvgPrice.forEach((category, avgPrice) -> 
            System.out.println(category + ": " + String.format("%.2f", avgPrice) + "원")
        );
        
        // 3. 가격대별 제품 분류
        System.out.println("\n가격대별 제품:");
        Map<String, List<Product>> priceRange = products.stream()
                                                      .collect(Collectors.groupingBy(product -> {
                                                          double price = product.getPrice();
                                                          if (price < 100000) return "10만원 미만";
                                                          else if (price < 500000) return "10만원~50만원";
                                                          else return "50만원 이상";
                                                      }));
        priceRange.forEach((range, prods) -> {
            System.out.println(range + ":");
            prods.forEach(p -> System.out.println("  - " + p.getName() + ": " + p.getPrice() + "원"));
        });
        
        // 4. 특정 조건의 상품 필터링 및 정렬
        System.out.println("\n20만원 이상의 전자기기 (이름순 정렬):");
        products.stream()
                .filter(p -> p.getCategory().equals("전자기기"))
                .filter(p -> p.getPrice() >= 200000)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
        
        // 5. 날짜 기준 필터링
        LocalDate cutoffDate = LocalDate.of(2023, 6, 1);
        System.out.println("\n" + cutoffDate + " 이후에 등록된 상품:");
        products.stream()
                .filter(p -> p.getRegistrationDate().isAfter(cutoffDate))
                .forEach(System.out::println);
        
        // 6. 문자열 처리 예제 (파일에서 단어 빈도수 계산)
        System.out.println("\n문자열 스트림 처리 예제:");
        
        // 샘플 텍스트
        String text = "스트림은 자바 8에서 추가된 기능으로, 컬렉션의 요소를 "
                     + "람다식으로 처리할 수 있게 해줍니다. 스트림을 이용하면 "
                     + "복잡한 데이터 처리 작업을 간결하게 표현할 수 있습니다. "
                     + "스트림은 원본 데이터를 변경하지 않고, 새로운 결과를 만들어냅니다.";
        
        // 단어 빈도수 계산
        Map<String, Long> wordFrequency = Arrays.stream(text.split("\\s+|\\.|,"))
                                               .filter(word -> !word.isEmpty())
                                               .collect(Collectors.groupingBy(
                                                   String::toLowerCase,
                                                   Collectors.counting()
                                               ));
        
        System.out.println("단어 빈도수 (내림차순):");
        wordFrequency.entrySet().stream()
                   .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                   .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + "번"));

    }
    
    /**
     * 파일에서 각 줄을 읽어 스트림으로 처리하는 예제
     * 실행 시 파일이 없으면 예외 발생하므로 주석 처리합니다.
     */
    public static void processFile(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.filter(line -> !line.isEmpty())
                 .map(String::trim)
                 .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }
} 