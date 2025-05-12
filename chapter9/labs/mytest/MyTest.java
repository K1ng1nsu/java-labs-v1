package chapter9.labs.mytest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        //설명: 정수 리스트가 주어졌을 때, 짝수만 골라서 제곱한 값을 새로운 리스트로 반환하세요.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list = nums.stream().filter(num -> num % 2 == 0).mapToInt(num -> num * num).boxed().toList();
        System.out.println(list);

        List<Integer> list1 = nums.stream().filter(num -> num % 2 == 0).map(num -> num * num).toList();
        System.out.println(list1);

        //설명: 문자열 리스트에서 길이가 5 이상인 단어만 골라 대문자로 바꾸고, 리스트로 반환하세요.
        List<String> words = Arrays.asList("hi", "hello", "functional", "java", "stream");
        List<String> list2 = words.stream().filter(word -> word.length() > 4).map(word -> word.toUpperCase()).toList();
        System.out.println(list2);

        //설명: 사용자(User) 객체 리스트가 있을 때, 모든 사용자의 평균 나이를 구하세요.

        List<User> users = List.of(new User("John", 34), new User("Jane", 45));
        users.stream().mapToInt(user -> user.getAge()).average().ifPresent(System.out::println);

//        설명: 사용자 객체 리스트에서 이름 첫 글자로 사용자들을 그룹핑해서 Map<Character, List<User>>를 반환하세요.
        Map<Character, List<User>> collect = users.stream().collect(Collectors.groupingBy(user -> user.getName().charAt(0)));


        Calculator add = (x, y) -> x + y;
        Calculator subtract = (x, y) -> x - y;
        Calculator multiply = (x, y) -> x * y;
        Calculator divide = (x, y) -> x / y;



    }


}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

@FunctionalInterface
interface Calculator {
    double calulate(double a, double b);
}
