package generic2;

public class GetableGenericInterface {
    public static void main(String[] args) {
        Box12<Toy3> box = new Box12<>();
        box.setOb(new Toy3());

        Getable<Toy3> gt = box; // Box12<T>가 Getable를 구현하므로 참조 가능
        System.out.println(gt.get());
    }
}

interface Getable<T> {
    public T get();
}

/**
 * 인터페이스 Getable<T>를 구현하는 Box12<T> 클래스
 * @param <T>
 */
class Box12<T> implements Getable<T> {
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public T get() {
        return ob;
    }
}

class Toy3 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}
