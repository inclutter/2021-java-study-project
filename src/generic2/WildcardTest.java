package generic2;

public class WildcardTest {
    public static void main(String[] args) {
        Box5<Integer> box5 = new Box5<>();
        box5.setOb(55);
        Unboxer3.peekBox(box5, 5);
        Box5<Object> box6 = new Box5<>();
        Unboxer3.setBox(box6,77);
    }
}

class Box5<T> {
    T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class Unboxer3 {
    public static <T> T openBox(Box5<T> box5) {
        return box5.getOb();
    }

    /**
     * 아래 와일드 카드의 경우
     * Number를 상속하는 하위 클래스가 올 수 있다.
     * 하위 클래스는 Integer와 Double이 올 수 있다.
     * wildecard extends의 경우 다음과 같이 to set을 할 수 없다.
     * 이유는 어떤 값을 저장할지 알 수 없기 때문이다.
     * to set을 하려고 하는 값이 어떤 값이 올지 알 수 없다.
     * 그 값이 double일지, 아니면 Integer일지 알 수 없으므로 다음과 같이 컴파일 에러가 발생한다.
     * @param box5
     */
    public static void peekBox(Box5<? extends Number> box5, int n) { // Wildcard 사용 메소드
        System.out.println(box5.getOb());
        // TODO : 컴파일 오류 확인 원할 경우 주석 해제
        // box5.setOb(n);
    }

    /**
     * 아래 와일드 카드의 경우
     * Integer 또는 Inter가 상속하는 클래스가 올 수 있다
     * 상속하는 클래스로는 Integer, Number, Object가 올 수 있다.
     * wildecard super의 경우 to get을 할 수 있다.
     * 정확히 말하자면 to get은 가능하나 값을 저장하는데에 제한이 있다.
     * 아래와 같이 Object 변수에는 저장이 가능하다 Object 변수의 경우 위에 상속하는 클래스에 최상위에 있으므로
     * 다음과 같이 어떤 타입이 와도 저장이 가능하다
     * 그러나 Integer 타입 변수의 경우 box5의 to get을 한 값이 어떤 값이 올지 알 수 없으므로 값을 저장을 할 수가 없게된다.
     * @param box5
     * @param n
     */
    public static void setBox(Box5<? super Integer> box5, int n) {
        box5.setOb(n);
        Object t = box5.getOb();
        // TODO : 컴파일 오류 확인 원할 경우 주석 해제
        // Integer k = box5.getOb();
        System.out.println(box5.getOb());
    }
}