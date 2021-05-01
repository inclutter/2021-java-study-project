package generic2;

public class GetableGenericInterface2 {
    public static void main(String[] args) {
        Box13<Toy4> box = new Box13<>();
        box.setOb(new Toy4());

        /**
         * Getable1<String>형 참조변수는 다음과 같이 Box14<T> 인스턴스를 T의 자료형에 상관없이 참조할 수 있다.
         * Box13의 참조변수가 Toy4여도 참조할 수 있음
         */
        Getable1<String> gt = box;
        System.out.println(gt.get());
    }
}

interface Getable1<T> {
    public T get();
}

class Box13<T> implements Getable1<String> {
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public String get() { // 반환형은 T가 아닌 String이어야 한다.
        return "I am a Toy";
    }
}

class Toy4 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}