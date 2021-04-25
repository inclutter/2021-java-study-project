package generic1;

public class BoxInBox {
    public static void main(String[] args) {
        /**
         * 박스를 세겹으로 포장했다.
         * 첫번째 박스
         */
        DoubleBox<String> sdoubleBox = new DoubleBox<>();
        sdoubleBox.setOb("I am so Happy");

        /**
         * 두번째 박스 앞서 선언한 제네릭 클래스 변수를 to set한다.
         */
        DoubleBox<DoubleBox<String>> wBox = new DoubleBox<>();
        wBox.setOb(sdoubleBox);

        /**
         * 세번째 박스 제네릭 클래스 변수를 to set한 제네릭 변수를 to set한다.
         * 이것이 제네릭 클래스으 장점인 듯 싶다.
         */
        DoubleBox<DoubleBox<DoubleBox<String>>> zBox = new DoubleBox<>();
        zBox.setOb(wBox);

        System.out.println(zBox.getOb().getOb().getOb());

    }
}

class DoubleBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}