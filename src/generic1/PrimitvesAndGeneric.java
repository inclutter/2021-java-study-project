package generic1;

/**
 * Primitive 자료형은 기본(원시) 자료형이라고 이해하면 편하고,
 * Integer, String과 같은 자료형은  Wrapper 클래스라고 이해하면 편하다.
 * Wrapper 클래스는 기본 자료형을 클래스로 정의해 놓은 것을 Wrapper라고 하니 참고하도록 하자.
 */
public class PrimitvesAndGeneric {
    public static void main(String[] args) {
        /**
         * 다음과 같이 기본(Primitive) 자료형이 올 경우 컴파일 에러가 발생한다.
         * 제네릭 클래스의 참조변수에는 기본 자료형이 올 수 없으며, Wrapper class만 올 수 있다.
         * TODO : 컴파일 에러 확인을 원할 경우 주석 해제
         */
        // PrimitvesBox<int> iBox = new PrimitvesBox<int>();

        /**
         * 다음과 같이 Wrapper class를 참조변수로 지정해야 정상적으로 변수에 저장이 가능하다.
         * 아래와 같이 기본 자료형(125)와 같은 값들은 다음과 같이 오토 박싱, 오토 언박싱되어 저장이 가능하다.
         */
        PrimitvesBox<Integer> primitvesBox = new PrimitvesBox<>();
        primitvesBox.setOb(125); // 오토 박싱 진행
        int boxOb = primitvesBox.getOb(); // 오토 언박싱 진행
    }
}

class PrimitvesBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
