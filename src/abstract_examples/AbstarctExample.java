package abstract_examples;

public class AbstarctExample {
    public static void main(String[] args) {
        MyHouse myHouse = new MyHouse();
        myHouse.methodOne();
        myHouse.methodTwo();
    }
}

/**
 * 하나 이상의 추상 메소드를 갖는 클래스를 가리켜 '추상 클래스'라 한다.
 * 예를 들어서 다음 클래스의 정의를 보자.
 * 이 클래스는 하나의 추상 메소드를 갖고 있으니 추상 클래스이다.
 * 그리고 이러한 추상 클래스에는 위에서 보이듯이 클래스의 선언부에 abstract 선언을 추가해야 한다.
 * 이러한 추상 클래스는 성격이 인터페이스와 유사하다.
 * 추상 클래스를 대상으로 인스턴스 생성도 불가능하며, 다른 클래스에 의해서 추상 메소드가 구현되어야 한다. ** 중요
 * 그럼에도 불구하고 이는 클래스이다.
 */
abstract class House {
    public void methodOne() {
        System.out.println("method one");
    }

    /**
     * 추상 클래스
     */
    public abstract void methodTwo();
}

/**
 * 그러므로 다음과 같이 methodTwo 메소드의 경우
 * 다음과 같이 MyHouse class에서 House class를 상속받아서 methodTwo 추상 메소드를 구현할 수 있다.
 * 또한 다음과 같이 구현의 형태가 아닌 상속의 형태를 띈다.(키워드를 implement가 아닌 extends를 사용했다는 의미)
 * 정리하면, 여느 클래스들과 마찬가지로 인스턴스 변수와 인스턴스 메소드를 갖지만,
 * 이를 상속하는 하위 클래스에 의해서 구현되어야 할 메소드가 하나 이상 있는 경우 이를 '추상 클래스'라 한다.
 */
class MyHouse extends House {
    @Override
    public void methodTwo() {
        System.out.println("method two");
    }
}

