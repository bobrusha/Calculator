
/**
 * Created by Aleksandra on 01.08.15.
 */
public class SupportedFunctions {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    private static final String OPERATORS = "+-*/";

    public static int getPriority(String op) throws Exception {
        switch (op) {
            case LEFT_BRACKET:
                return 0;
            case PLUS:
            case MINUS:
                return 1;
            case MULTIPLICATION:
            case DIVISION:
                return 2;
            case RIGHT_BRACKET:
                return 3;
            default:
                throw (new Exception()); // not supported func
        }
    }

    public static double calculate(double firstNumber, double secondNumber, String op) throws Exception {
        switch (op) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                return firstNumber / secondNumber;
            default:
                throw new Exception(); // not supported function
        }
    }

    public static boolean isOperator (String op) {
        if (OPERATORS.contains(op))
            return true;
        else
            return false;
    }
}
