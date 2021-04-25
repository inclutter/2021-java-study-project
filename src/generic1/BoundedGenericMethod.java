package generic1;

public class BoundedGenericMethod {
    public static void main(String[] args) {
        BoundedGenericBox<Integer> sBox = BoundedBoxFactory.makeBox(new Integer(5959));
        int n = BoundedUnboxer.openBox(sBox);
        System.out.println("Returned data : " + n);

    }
}

class BoundedGenericBox<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class BoundedBoxFactory {
    /**
     * 다음 method의 경우 Type인자를 Number class를 상속하는 클래스로 제한하였다.
     * @param o
     * @param <T> - 제한된 type 인자
     * @return
     */
    public static <T extends Number> BoundedGenericBox<T> makeBox(T o) {
        BoundedGenericBox<T> box = new BoundedGenericBox<T>();
        box.setOb(o);

        // 타입인자 제한으로 intValue를 호출 할 수가 있다.
        System.out.println("Boxed data : " + o.intValue());
        return box;
    }
}

class BoundedUnboxer {
    /**
     * 다음 method의 경우 Type인자를 Number class를 상속하는 클래스로 제한하였다.
     * @param box
     * @param <T> - 제한된 type 인자
     * @return
     */
    public static <T extends Number> T openBox(BoundedGenericBox<T> box) {
        // 타입인자 제한으로 intValue를 호출 할 수가 있다.
        System.out.println("Unboxed data : " + box.getOb().intValue());
        return box.getOb();
    }
}