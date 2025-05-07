package chapter8.examples.ex3;

/**
 * Ex 3: 학생 클래스
 * 
 * ArrayList와 함께 사용할 학생 객체 클래스
 */
public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int age;
    private double gpa;
    
    public Student(int id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    @Override
    public String toString() {
        return String.format("학생[ID: %d, 이름: %s, 나이: %d, 평점: %.1f]", id, name, age, gpa);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return id == other.id;
    }
    
    @Override
    public int hashCode() {
        return id;
    }
    
    @Override
    public int compareTo(Student other) {
        // ID 기준으로 정렬 (기본 정렬 기준)
        return Integer.compare(this.id, other.id);
    }
} 