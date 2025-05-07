package chapter8.examples.ex4;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Ex 4: TreeSet 예제
 * 
 * TreeSet의 기본 사용법과 정렬 및 탐색 기능을 보여주는 예제입니다.
 */
public class TreeSetExample {
    public static void main(String[] args) {
        // 기본 TreeSet 생성 (자연 정렬 순서)
        TreeSet<Integer> numbers = new TreeSet<>();
        
        // 요소 추가
        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(60);
        numbers.add(30);
        numbers.add(70);
        numbers.add(40);
        
        System.out.println("=== TreeSet 기본 특성 ===");
        System.out.println("TreeSet의 요소: " + numbers);
        System.out.println("요소 개수: " + numbers.size());
        
        // TreeSet의 요소 검색 메소드
        System.out.println("\n=== 요소 검색 ===");
        System.out.println("첫 번째 요소: " + numbers.first());
        System.out.println("마지막 요소: " + numbers.last());
        System.out.println("35보다 큰 최소 요소: " + numbers.higher(35));
        System.out.println("35보다 작은 최대 요소: " + numbers.lower(35));
        System.out.println("40 이상의 최소 요소: " + numbers.ceiling(40));
        System.out.println("40 이하의 최대 요소: " + numbers.floor(40));
        
        // 범위 검색
        System.out.println("\n=== 범위 검색 ===");
        SortedSet<Integer> subSet1 = numbers.subSet(30, 70);
        System.out.println("30 이상 70 미만의 요소: " + subSet1);
        
        NavigableSet<Integer> subSet2 = numbers.subSet(30, true, 70, true);
        System.out.println("30 이상 70 이하의 요소: " + subSet2);
        
        SortedSet<Integer> headSet = numbers.headSet(50);
        System.out.println("50 미만의 요소: " + headSet);
        
        SortedSet<Integer> tailSet = numbers.tailSet(50);
        System.out.println("50 이상의 요소: " + tailSet);
        
        // 역순 순회
        System.out.println("\n=== 역순 순회 ===");
        NavigableSet<Integer> descendingSet = numbers.descendingSet();
        System.out.println("TreeSet 역순: " + descendingSet);
        
        // 사용자 정의 Comparator로 TreeSet 생성
        TreeSet<Person> people = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 나이 기준 정렬
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
        
        people.add(new Person("윤사람", 25));
        people.add(new Person("김사람", 30));
        people.add(new Person("박사람", 28));
        people.add(new Person("이사람", 22));
        people.add(new Person("정사람", 35));
        
        System.out.println("\n=== 사용자 정의 객체의 TreeSet ===");
        for (Person person : people) {
            System.out.println(person);
        }
        
        // pollFirst, pollLast 메소드
        System.out.println("\n=== 요소 추출 ===");
        System.out.println("최소값 추출: " + numbers.pollFirst());
        System.out.println("최대값 추출: " + numbers.pollLast());
        System.out.println("추출 후 TreeSet: " + numbers);
    }
    
    /**
     * 사용자 정의 Person 클래스
     */
    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public int getAge() {
            return age;
        }
        
        @Override
        public String toString() {
            return name + " (" + age + "세)";
        }
    }
} 