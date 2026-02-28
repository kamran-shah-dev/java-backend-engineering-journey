package Generics;

enum operations {
    ADD, SUB, MUL, DIV;
    public <T extends Number> double op(T a, T b) {
        switch (this) {
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUB:
                return a.doubleValue() - b.doubleValue();
            case DIV:
                return a.doubleValue() / b.doubleValue();
            case MUL:
                return a.doubleValue() * b.doubleValue();
            default: return 0;
        }
    }

}
public class genericEnum {
    public static void main(String[] args) {
        System.out.println(operations.MUL.op(5,7));
    }
}
