package chapter4.examples.ex5.other;

/**
 * 다른 패키지에 있는 클래스 예제
 */
public class OtherClass {
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
        System.out.println("OtherClass: 이것은 public 메소드입니다.");
    }
    
    // protected 메소드
    protected void protectedMethod() {
        System.out.println("OtherClass: 이것은 protected 메소드입니다.");
    }
    
    // default 메소드
    void defaultMethod() {
        System.out.println("OtherClass: 이것은 default 메소드입니다.");
    }
    
    // private 메소드
    private void privateMethod() {
        System.out.println("OtherClass: 이것은 private 메소드입니다.");
    }
    
    // private 필드에 접근하기 위한 getter
    public int getPrivateField() {
        return privateField;
    }
    
    // private 필드를 변경하기 위한 setter
    public void setPrivateField(int privateField) {
        this.privateField = privateField;
        System.out.println("OtherClass: private 필드 값이 " + privateField + "으로 설정되었습니다.");
    }
} 