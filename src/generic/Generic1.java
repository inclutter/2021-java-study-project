package generic;

public class Generic1 {
    public static void main(String[] args) {
        Toy toy = new Toy();
        System.out.println(toy);
    }
}

class Toy {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}
