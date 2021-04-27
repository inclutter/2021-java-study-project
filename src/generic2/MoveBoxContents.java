package generic2;

public class MoveBoxContents {
}

class Box7<T> {
    private T ob;

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }
}

class Toy1 {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxContentsMover {
    public static void moveBox(Box7<? super Toy1> to, Box7<? extends Toy1> from) {
        to.setOb(from.getOb());
        to.getOb();
    }
}