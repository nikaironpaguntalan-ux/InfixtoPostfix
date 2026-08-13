
import java.util.*;

public class CalPostfix extends InfixToPostfix {

    public double CalPostfix(ArrayList<String> PostfixList) {

        ArrayList<Double> stack = new ArrayList<>();

        for (String Cal : PostfixList) {

            String check="";
            char tk=Cal.charAt(0);
            check+=tk;

            if (isOperand(check)) {
                System.out.println("PUSH " + Cal);
                stack.add(Double.parseDouble(Cal));
            } else{
                double operand2 = stack.remove(stack.size() - 1);
                System.out.println("POP " + operand2);
                double operand1 = stack.remove(stack.size() - 1);
                System.out.println("POP " + operand1);
                double result=0;
                if (check.equals("+")) {
                    result = operand1 + operand2;
                } else if (check.equals("-")) {
                    result = operand1 - operand2;
                } else if (check   .equals("*")) {
                    result = operand1 * operand2;
                } else if (check.equals("/")) {
                    result = operand1 / operand2;
                } else if (check.equals("^")) {
                    result = (Math.pow(operand1, operand2));
                }
                stack.add(result);
                System.out.println("PUSH " + result);

            }
        }

        return stack.get(0);
    }
}
