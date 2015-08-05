
import java.util.ArrayDeque;

/**
 * Created by Aleksandra on 30.07.15.
 * Based on Dijkstra's shunting yard algorithm
 */
public class Parser {

    private StringBuilder exprResidual;
    private ArrayDeque<Double> numbers;
    private ArrayDeque<String> operators;

    public double evaluate(String strMathExpreession) throws UnclosedParenthesisException {
        numbers = new ArrayDeque<>();
        operators = new ArrayDeque<>();
        exprResidual = new StringBuilder(strMathExpreession);

        while (exprResidual.length() != 0) {
            if (Character.isDigit(exprResidual.charAt(0))) {
                addToNumbers();
                continue;
            }

            String op1 = exprResidual.substring(0, 1);

            if (op1.equals(SupportedFunctions.LEFT_BRACKET)) {
                operators.push(op1);
                exprResidual.delete(0, 1);
                continue;
            }

            if (op1.equals(SupportedFunctions.RIGHT_BRACKET)) {
                while (!operators.isEmpty() && !operators.peekFirst().equals(SupportedFunctions.LEFT_BRACKET)) {
                    try {
                        numbers.push(SupportedFunctions.calculate(numbers.pop(), numbers.pop(), operators.pop()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                exprResidual.delete(0, 1);
                if (operators.isEmpty()) {
                    throw new UnclosedParenthesisException();
                } else {
                    operators.pop();
                }
                continue;
            }

            if (SupportedFunctions.isOperator(op1)) {
                try {
                    while (!operators.isEmpty() && SupportedFunctions.getPriority(op1)
                            <= SupportedFunctions.getPriority(operators.getFirst())) {

                        numbers.push(SupportedFunctions.calculate(numbers.pop(), numbers.pop(), operators.pop()));
                    }
                    operators.push(op1);
                    exprResidual.delete(0, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        while (!operators.isEmpty()) {

            if (operators.getFirst().equals(SupportedFunctions.LEFT_BRACKET))
                throw new UnclosedParenthesisException();
            try {
                numbers.addLast(SupportedFunctions.calculate(numbers.pop(), numbers.pop(), operators.pop()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return numbers.pop();
    }


    private void addToNumbers() {
        int i = 1;
        while (i < exprResidual.length() &&
                (Character.isDigit(exprResidual.charAt(i)) || exprResidual.charAt(i) == ',')) {
            ++i;
        }
        String num = exprResidual.substring(0, i);
        exprResidual.delete(0, i);
        numbers.push(Double.parseDouble(num));
    }


}
