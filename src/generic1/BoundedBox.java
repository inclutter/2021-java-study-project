package generic1;

import access_level_modifiers.Cat;

public class BoundedBox {
    public static void main(String[] args) {
        FourthBox<Integer> iBox = new FourthBox<>();
        iBox.setOb(24); // Integer는 Number를 상속

        FourthBox<Double> dBox = new FourthBox<>();
        dBox.setOb(5.97); // Double은 Number를 상속

        System.out.println(iBox.getOb());
        System.out.println(dBox.getOb());
    }
}

/**
 * 아래와 같이 인스턴스 생성시 타입 인자로 특정 클래스를 상속 안했을 경우
 * 다음과 같이 Number class의 intValue 메소드를 호출할 수 없다.
 * 이유는 참조변수 ob가 차좀하게 될 것은 인스턴스이다.
 * 하지만 어떠한 클래스의 인스턴스를 참조하게 될지 알 수 없기 때문에 ob를 통해서 호출할 수 있는 메소드는 Object 클래스의 메소드로 제한이 된다.
 * @param <T>
 */
class FifthBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    // TODO : 컴파일 에러 확인을 원할 경우 주석 해제
//    public int toIntValue() {
//        return this.ob.intValue();
//    }

}

/**
 * 다음과 같이 인스턴시 생성 시 타입 인자로 Number 또는 이를 상속하는 클래스만 오게 할 수 있다.
 * 반면 다음과 같이 타입 인자를 제한하면 Number class의 intValue 메소드를 호출 할 수 있다.
 * ob가 참조하는 인스턴스는 intValue 메소드를 가지고 있음을 100퍼센트 보장할 수 있기 때문이다.
 * @param <T>
 */
class FourthBox<T extends Number> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public int toIntValue() {
        return this.ob.intValue();
    }
}