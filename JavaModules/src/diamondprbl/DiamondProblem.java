package diamondprbl;

interface A {
    default void show() {
        System.out.println("Class A");
    }
}

interface B extends A {
    default void show() {
        System.out.println("Class B");
    }
}

interface C extends A {
    default void show() {
        System.out.println("Class C");
    }
}

public class DiamondProblem implements B, C {
    @Override
    public void show() {
     
        B.super.show();   
        System.out.println("Class D");
    }

    public static void main(String[] args) {
        DiamondProblem obj = new DiamondProblem();
        obj.show();
    }
}
