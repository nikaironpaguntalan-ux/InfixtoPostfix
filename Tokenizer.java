public class Tokenizer extends Parent {

    public void Tokenize(String input) {
        this.usrInput = input;

        String storeOperand = "";

        for (int i = 0; i < usrInput.length(); i++) {
            char c = usrInput.charAt(i);
            String current = String.valueOf(c);

            if (Character.isDigit(c)) {
                storeOperand += current;
            } else if (isOperator(current)) {

                if (!storeOperand.isEmpty()) {
                    OperandList.add(storeOperand);
                    Tokenized.add(storeOperand);   
                    storeOperand = "";
                }

                    OperatorList.add(current);
                Tokenized.add(current);           
            } else {
                System.out.println("Invalid input");
            }
        }

        if (!storeOperand.isEmpty()) {
            OperandList.add(storeOperand);
            Tokenized.add(storeOperand);         
        }
    }

    public static boolean isOperator(String input) {
        String[] operators = {"+", "-", "*", "/", "^", "(", ")"};
        for (String op : operators) {
            if (op.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperand(String input) {
        String[] operands = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String op : operands) {
            if (op.equals(input)) {
                return true;
            }
        }
        return false;
    }
}