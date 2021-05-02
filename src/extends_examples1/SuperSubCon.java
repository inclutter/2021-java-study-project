package extends_examples1;

public class SuperSubCon {
    public static void main(String[] args) {
        new SubCLS();
    }
}

class SuperCLS {
    public SuperCLS() { // 생성자
        System.out.println("I'm Super Class");
    }
}

class SubCLS extends SuperCLS {
    public SubCLS() { // 생성자
        System.out.println("I'm Sub Class");
    }
}