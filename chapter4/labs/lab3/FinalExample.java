package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    public final String BASEURL = "https://api.github.com/";
    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    public final String PORTNUMBER;
    
    // TODO: 생성자를 정의하세요.
    public FinalExample() {
        // final 변수 초기화
        PORTNUMBER = "443";
    }
    
    // TODO: final 메소드를 정의하세요.

    public final String getBaseURL() {
        return BASEURL;
    }
    
    
    // TODO: final 매개변수를 받는 메소드를 정의하세요.

    public boolean checkPortNumber(final String portNumber) {
//        portNumber = "1"; cant change
        return PORTNUMBER.equals(portNumber);
    }


    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample fe = new FinalExample();

        
        
        // TODO: 객체의 메소드를 호출하세요.
        boolean isCorrect = fe.checkPortNumber("443");

        System.out.println(isCorrect);

        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.


        // TODO: final 지역 변수를 선언하고 사용하세요.

    }
}

// TODO: final 클래스를 정의하세요.

final class ZIPCODE{
    String NUM = "0123456789";

    public String getNUM() {
        return NUM;
    }
}


// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
class animal{
    final void sound(){
        System.out.println("M?E?O?W");
    }

}

class cat extends animal{
//    void sound(){
//        System.out.println("M?E?O?W");
//    }
}