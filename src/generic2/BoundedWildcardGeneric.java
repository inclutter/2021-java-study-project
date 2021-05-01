package generic2;

public class BoundedWildcardGeneric {

    /**
     * box에 con과 동일한 내용물이 들었는지 확인
     *
     * @param box - 기존 Box11<T> box 선언에서 Box11<? extends T>로 수정하여 에러를 해결할 수 있다.
     * @param con
     * @param <T>
     * @return
     */
    public static <T> boolean compBox(Box11<? extends T> box, T con) {
        T bc = box.getOb();
        // TODO : 에러 발생하는 부분 확인을 원할 경우 주석 해제
        // box.setOb(con); // 프로그래머의 실수로 삽입된 문장 때문에 내용물이 바뀐다.
        return bc.equals(con);
    }

    public static void main(String[] args) {
        Box11<Integer> box1 = new Box11<>();
        box1.setOb(24);
        Box11<String> box2 = new Box11<>();
        box2.setOb("Poly");

        if(compBox(box1,25))
            System.out.println("상자 안에 25 저장");
        if(compBox(box2, "Moly"))
            System.out.println("상자 안에 Moly 저장");

        System.out.println(box1.getOb());
        System.out.println(box2.getOb());
    }
}

class Box11<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}
