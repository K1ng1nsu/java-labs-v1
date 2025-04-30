package chapter4.examples.ex5;

/**
 * 접근 제한자 활용 예제
 */
public class AccessModifierExample {
    public static void main(String[] args) {
        // 객체 생성
        MyClass myClass = new MyClass();
        
        // public 멤버 접근 - 어디서든 접근 가능
        myClass.publicField = 100;
        myClass.publicMethod();
        
        // protected 멤버 접근 - 같은 패키지 내에서 접근 가능
        myClass.protectedField = 200;
        myClass.protectedMethod();
        
        // default 멤버 접근 - 같은 패키지 내에서 접근 가능
        myClass.defaultField = 300;
        myClass.defaultMethod();
        
        // private 멤버 접근 - 같은 클래스 내에서만 접근 가능
        // myClass.privateField = 400; // 에러: private 필드에 접근 불가
        // myClass.privateMethod(); // 에러: private 메소드에 접근 불가
        
        // private 멤버는 public 메소드를 통해 간접적으로 접근 가능
        myClass.setPrivateField(400);
        System.out.println("private 필드 값: " + myClass.getPrivateField());
        
        // 다른 패키지의 클래스에 접근
        System.out.println("\n다른 패키지의 클래스 사용:");
        chapter4.examples.ex5.other.OtherClass otherClass = new chapter4.examples.ex5.other.OtherClass();
        
        // public 멤버만 다른 패키지에서 접근 가능
        otherClass.publicField = 500;
        otherClass.publicMethod();
        
        // protected, default, private 멤버는 다른 패키지에서 접근 불가
        // otherClass.protectedField = 600; // 에러: protected 필드에 다른 패키지에서 접근 불가
        // otherClass.protectedMethod(); // 에러: protected 메소드에 다른 패키지에서 접근 불가
        // otherClass.defaultField = 700; // 에러: default 필드에 다른 패키지에서 접근 불가
        // otherClass.defaultMethod(); // 에러: default 메소드에 다른 패키지에서 접근 불가
        
        // 접근자(getter)와 설정자(setter)를 통한 접근
        otherClass.setPrivateField(800);
        System.out.println("다른 패키지의 private 필드 값: " + otherClass.getPrivateField());
    }
}

/**
 * 접근 제한자를 보여주는 클래스
 */
class MyClass {
    // public: 모든 클래스에서 접근 가능
    public int publicField;
    
    // protected: 같은 패키지 + 상속 관계의 클래스에서 접근 가능
    protected int protectedField;
    
    // default(접근 제한자 없음): 같은 패키지에서만 접근 가능
    int defaultField;
    
    // private: 같은 클래스 내에서만 접근 가능
    private int privateField;
    
    // public 메소드
    public void publicMethod() {
        System.out.println("이것은 public 메소드입니다.");
        // private 멤버는 같은 클래스 내에서 접근 가능
        privateMethod();
    }
    
    // protected 메소드
    protected void protectedMethod() {
        System.out.println("이것은 protected 메소드입니다.");
    }
    
    // default 메소드
    void defaultMethod() {
        System.out.println("이것은 default 메소드입니다.");
    }
    
    // private 메소드
    private void privateMethod() {
        System.out.println("이것은 private 메소드입니다.");
    }
    
    // private 필드에 접근하기 위한 getter
    public int getPrivateField() {
        return privateField;
    }
    
    // private 필드를 변경하기 위한 setter
    public void setPrivateField(int privateField) {
        // 추가 로직(유효성 검사 등)을 넣을 수 있음
        if (privateField >= 0) {
            this.privateField = privateField;
            System.out.println("private 필드 값이 " + privateField + "으로 설정되었습니다.");
        } else {
            System.out.println("유효하지 않은 값입니다. 0 이상의 값을 입력하세요.");
        }
    }
} 