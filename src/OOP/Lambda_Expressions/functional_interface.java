package OOP.Lambda_Expressions;

interface returnWithSymbol {
    String run(String symbol);
}

public class functional_interface {
    public static void main(String[] args) {

        int number1 = 6;
        int number2 = 7;

        returnWithSymbol add = (s) -> s + " + ";
        returnWithSymbol sub = (s) -> s + " - ";
        returnWithSymbol mul = (s) -> s + " x ";

        simpleCalc(number1, number2, add);
        simpleCalc(number1, number2, sub);
        simpleCalc(number1, number2, mul);
    }

    static void simpleCalc(int num1, int num2, returnWithSymbol s) {
        String expression = s.run(Integer.toHexString(num1)) + " " + num2;

        if(expression.contains("+")) System.out.println(expression + " = " + (num1 + num2));
        else if (expression.contains("-")) System.out.println(expression + " = " + (num1 - num2));
        else System.out.println(expression + " = " + (num1 * num2));
    }
}
