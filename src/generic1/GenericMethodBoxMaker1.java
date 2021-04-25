package generic1;

public class GenericMethodBoxMaker1 {
    public static void main(String[] args) {
        // Generic method를 상자에 담은 후 해당 인스턴스를 반환하고,
        // 해당 인스턴스는 Generic class의 variable에 저장된다.
        GenericMethodBox<String> sBox = BoxFactory.makeBox("Sweet");
        System.out.println(sBox.getOb());

        // 자료형은 다음과 같이 다르게 처리할 수도 있다.
        GenericMethodBox<Double> dBox = BoxFactory.makeBox(7.59);
        System.out.println(dBox.getOb());
    }
}

class GenericMethodBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class BoxFactory {
    /**
     * GenericMethod 정의
     * @param o
     * @param <T>
     * @return
     */
    public static <T> GenericMethodBox<T> makeBox(T o) {
        GenericMethodBox<T> tBox = new GenericMethodBox<>(); // 상자를 생성하고,
        tBox.setOb(o); // 전달된 인스턴스를 상자에 담아서,
        return tBox; // 이 상자를 반환한다.
    }
}