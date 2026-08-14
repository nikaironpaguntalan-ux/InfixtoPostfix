import java.util.*;

public class InfixToPostfix extends Tokenizer {

    public ArrayList<String> convert() {
        ArrayList<String> opStack = new ArrayList<>(); 
        PostfixList.clear();
        
        System.out.println();

        for (String tok : Tokenized) {

            String check="";
            char tk=tok.charAt(0);
            check+=tk;

            if (isOperand(check)) {
                PostfixList.add(tok);
                System.out.println(tok+"\t"+opStack +"\t"+ PostfixList);

            } else if (tok.equals("(")) {
                opStack.add(tok);
                System.out.println(tok+"\t"+opStack +"\t"+ PostfixList);

            } else if (tok.equals(")")) {
                while (!opStack.isEmpty() && !opStack.get(opStack.size() - 1).equals("(")) {
                    PostfixList.add(opStack.remove(opStack.size() - 1));
                }
                if (!opStack.isEmpty()) {
                    opStack.remove(opStack.size() - 1); 
                }
                System.out.println(tok+"\t"+opStack +"\t"+ PostfixList);

            } else if (isOperator(tok)) {
                char currentOp = tok.charAt(0);
                while (!opStack.isEmpty()
                        && !opStack.get(opStack.size() - 1).equals("(")
                        && Precedence.getPrecedence(opStack.get(opStack.size() - 1).charAt(0))
                           >= Precedence.getPrecedence(currentOp)) {
                    PostfixList.add(opStack.remove(opStack.size() - 1));
                }
                opStack.add(tok);
                System.out.println(tok+"\t"+opStack +"\t"+ PostfixList);
            }
        }

        while (!opStack.isEmpty()) {
            PostfixList.add(opStack.remove(opStack.size() - 1));
        }

        return PostfixList;
    }
}
    
