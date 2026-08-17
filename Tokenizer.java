public class Tokenizer extends Parent {

    public void Tokenize(String input) {
        this.usrInput = input;

        String storeOperand = "";

        for (int i = 0; i < usrInput.length(); i++) {
            char c = usrInput.charAt(i);
            String current = String.valueOf(c);
            if (c == '-' &&
                    (i == 0 || isOperator(String.valueOf(usrInput.charAt(i - 1))))) {
                storeOperand += current;
            } else if (isOperator(current)) {
                if (!storeOperand.isEmpty()) {
                    OperandList.add(storeOperand);
                    Tokenized.add(storeOperand);
                    storeOperand = "";
                }
                OperatorList.add(current);
                Tokenized.add(current);
            } else if (Character.isDigit(c) || c == '.') {
                storeOperand += current;
            } else {
                System.out.println("Invalid character");
            }
        }
        if (!storeOperand.isEmpty()) {
            OperandList.add(storeOperand);
            Tokenized.add(storeOperand);
        }
    }

    public static boolean isOperator(String input) {
        String[] operators = { "+", "-", "*", "/", "^", "(", ")" };
        for (String op : operators) {
            if (op.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperand(String input) {

        int decimalCount = 0;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (c == '-' && i == 0) {
                continue;
            }

            if (c == '.') {

                decimalCount++;

                if (decimalCount > 1) {
                    return false;
                }

            } else if (!Character.isDigit(c)) {

                return false;
            }
        }

        return true;
    }
}