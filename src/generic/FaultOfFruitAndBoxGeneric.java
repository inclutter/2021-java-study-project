package generic;

class Apple {
    @Override
    public String toString() {
        return "I am an apple.";
    }
}

class Orange {
    @Override
    public String toString() {
        return "I am an orange.";
    }
}

/**
 * Box 클래스는 이미 있어서 duplicate 오류가 발생함
 * 그러므로 같은 패키지 내에서는 이름을 달리해야 함
 * @param <T>
 */
class FruitBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

}

public class FaultOfFruitAndBoxGeneric {
    public static void main(String[] args) {
        /**
         * generic은 일반화를 나타냄
         * FruitBox 클래스의 T를 Apple클래스와 Orange 클래스로 정의함
         */
        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        FruitBox<Orange> orangeFruitBox = new FruitBox<>();

        /**
         * 그러므로 다음과 같이 String 자료형으로 to set을 진행하면 컴파일 오류가 발생함
         * TODO : 오류 확인을 원할 경우 주석해제
         */
        // appleFruitBox.setOb("Apple"); // 프로그래머의 실수
        // orangeFruitBox.setOb("Orange"); // 프로그래머의 실수

        /**
         * 위에 선언과 같이 Apple class로 to set 해야 정상적으로 complie이 가능하다.
         */
        appleFruitBox.setOb(new Apple());
        orangeFruitBox.setOb(new Orange());

        /**
         * 같은 class라도 to set이 되는 것은 아니다.
         * 위에 generic 자료형을 선언한 것과 동일한 자료형만 to set이 가능하다.
         * TODO : 오류 확인을 원할 경우 주석해제
         */
        // appleFruitBox.setOb(new Orange());
        // orangeFruitBox.setOb(new Apple());

        Apple ap = appleFruitBox.getOb();
        Orange og = orangeFruitBox.getOb();

        System.out.println(ap);
        System.out.println(og);

    }
}
