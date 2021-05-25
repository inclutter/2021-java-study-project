package nested_class_and_lamda;

public class Lamda3 {
    public static void main(String[] args) {
        Printable prn = (System.out::println);
        prn.print("ss");
    }
}

interface Printable {
    void print(String s);
}
