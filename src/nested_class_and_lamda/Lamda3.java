package nested_class_and_lamda;

public class Lamda3 {
    public static void main(String[] args) {
        Printable prn = (s -> {
            String p = s;
            System.out.println(p);});
        prn.print("ss");
    }
}

interface Printable {
    void print(String s);
}
