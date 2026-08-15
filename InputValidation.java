public class InputValidation extends Tokenizer {

    public  boolean withSpace(String input){
        if (input.contains(" ")) {
            System.out.println("Invalid input. Please enter a valid infix expression without spaces.");
            return true;
        }
        return false;
    }

    public boolean invalidChars(String input){
        for (char c : input.toCharArray()) {
            if (!isOperand(Character.toString(c)) && !isOperator(Character.toString(c)) && c != '(' && c != ')') {
                System.out.println("Invalid input. Please enter a valid infix expression with only digits, operators, and parentheses.");
                return true;
            }
        }
        return false;
    }





    public boolean emptyParentheses(String input){
        if (input.contains("()")) {
            System.out.println("Invalid input. Please enter a valid infix expression without empty parentheses.");
            return true;
        }
        return false;
    }

    public boolean doubleOperator(String input){
        if (input.contains("++") || input.contains("--") || input.contains("**") || input.contains("//") || input.contains("^^")) {
            System.out.println("Invalid input. Please enter a valid infix expression without consecutive operators.");
            return true;
        }
        return false;
    }

    public boolean UnclosedParentheses(String input){
        int OpenParenthesesCount = 0;
        int CloseParenthesesCount = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                OpenParenthesesCount++;
            } else if (c == ')') {
                CloseParenthesesCount++;
            }
        }
        if (OpenParenthesesCount != CloseParenthesesCount) {
            System.out.println("Invalid input. Please enter a valid infix expression with balanced parentheses.");
            return true;
        }
        return false;
    }

    public boolean noOperator(String input){
        String[] operators = {"+", "-", "*", "/", "^"};
        for (String op : operators) {
            if (input.contains(op)) {
                return false;
            }
        }
        System.out.println("Invalid input. Please enter a valid infix expression with at least one operator.");
        return true;
    }

    public boolean noOperand(String input){
        String[] operands = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String op : operands) {
            if (input.contains(op)) {
                return false;
            }
        }
        System.out.println("Invalid input. Please enter a valid infix expression with at least one operand.");
        return true;
    }

    public boolean OperatorBeforeandAfterParentheses(String input){
        if (input.contains("()") || input.contains("(+") || input.contains("(-")|| input.contains("(*") 
        ||input.contains("(/") || input.contains("(^") || input.contains("+)") 
        || input.contains("-)") || input.contains("*)") || input.contains("/)") || input.contains("^)")) {
            System.out.println("Invalid input. Please enter a valid infix expression with an operator before parentheses.");
            return true;
        }
        return false;

    }

    public boolean noOperatorBeforeParentheses(String input) {

        for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == '(' && i > 0) {

            char before = input.charAt(i - 1);

            if (Character.isDigit(before) || before == ')') {
                System.out.println("Invalid input. Operator required before '('");
                return true;
            }
        }
        if (input.charAt(i) == ')' && i < input.length() - 1) {

            char after = input.charAt(i + 1);

            if (Character.isDigit(after) || after == '(') {
                System.out.println("Invalid input. Operator required after ')'");
                return true;
            }
        }
    }

        return false;
    }


    public boolean DivisionByZero(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '0') {
                System.out.println("Invalid input. Division by zero is not allowed.");
                return true;
            }
        }
        return false;
    }

    public boolean startsWithOperator (String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '/' || c == '^') {
                System.out.println("Invalid input. Expression cannot start with an operator.");
                return true;
            } else if (Character.isDigit(c) || c == '(') {
                break;
            }
        }
        return false;
    }

    public boolean endsWithOperator (String input){
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                System.out.println("Invalid input. Expression cannot end with an operator.");
                return true;
            } else if (Character.isDigit(c) || c == ')') {
                break;
            }
        }
        return false;
    }


}

