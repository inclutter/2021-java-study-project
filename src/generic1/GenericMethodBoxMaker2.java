package generic1;

public class GenericMethodBoxMaker2 {
    public static void main(String[] args) {
        GenericMethodBox2<String> sBox = new GenericMethodBox2<>();
        sBox.setOb("My Generic Method");

        // 아래 메소드 호출의 경우 T의 type이 String이어야 하므로 타입 인자가 String으로 결정되었다.
        String str = Unboxer.<String>openBox(sBox);

        // 그러나 다음과 같이 참조변수에 전달하는 참조변수 전달 인자의 경우 아래와 같이 생략해도 무방하다.
        str = Unboxer.openBox(sBox);
        System.out.println(str);
    }
}

class GenericMethodBox2<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}


class Unboxer {
    /**
     * 다음 메소드의 경우 <T>는 타입 매개변수임을 알리는 표시이다.
     * 만약 <T>가 아래 메소드 정의 앞에 없을 경우 컴파일러는 에러를 발생한다.
     * 이유는 (GenericMethodBox2<T> box)에서 저 <T>가 무엇인지에 대한 에러를 발생한다.
     * 그러므로 함수 정의시 앞에 <T>를 입력해줘야 한다.
     *
     * @param box - parameter 값으로 Generic class box를 전달한다.
     * @param <T> - 해당 parameter의 경우 참조 변수로 T를 전달한다는 의미이다.
     * @return - 리턴의 경우 참조 변수 T를 반환한다.
     */
    public static <T> T openBox(GenericMethodBox2<T> box) {
        return box.getOb();
    }
}
