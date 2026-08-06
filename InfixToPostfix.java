import java.util.*;

public class InfixToPostfix extends Tokenizer {

    public ArrayList<String> convert() {
        ArrayList<String> opStack = new ArrayList<>(); 
        PostfixList.clear();

        for (String tok : Tokenized) {

            if (isNumeric(tok)) {
                PostfixList.add(tok);

            } else if (tok.equals("(")) {
                opStack.add(tok);

            } else if (tok.equals(")")) {
                while (!opStack.isEmpty() && !opStack.get(opStack.size() - 1).equals("(")) {
                    PostfixList.add(opStack.remove(opStack.size() - 1));
                }
                if (!opStack.isEmpty()) {
                    opStack.remove(opStack.size() - 1); 
                }

            } else if (isOperator(tok)) {
                char currentOp = tok.charAt(0);
                while (!opStack.isEmpty()
                        && !opStack.get(opStack.size() - 1).equals("(")
                        && Precedence.getPrecedence(opStack.get(opStack.size() - 1).charAt(0))
                           >= Precedence.getPrecedence(currentOp)) {
                    PostfixList.add(opStack.remove(opStack.size() - 1));
                }
                opStack.add(tok);
            }
        }

        while (!opStack.isEmpty()) {
            PostfixList.add(opStack.remove(opStack.size() - 1));
        }

        return PostfixList;
    }

    
    private boolean isNumeric(String tok) {
        return tok.matches("[0-9]+");
    }
}
    
