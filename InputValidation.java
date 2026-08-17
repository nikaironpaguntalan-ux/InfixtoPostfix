public class InputValidation extends Tokenizer {

    public  boolean withSpace(String input){
        if (input.contains(" ")) {
    
            return true;
        }
        return false;
    }

    public boolean invalidChars(String input){
        for (char c : input.toCharArray()) {
            if (!isOperand(Character.toString(c)) && !isOperator(Character.toString(c)) && c != '(' && c != ')') {
               
            }
        }
        return false;
    }





    public boolean emptyParentheses(String input){
        if (input.contains("()")) {
            return true;
        }
        return false;
    }

    public boolean doubleOperator(String input){
        if (input.contains("++") || input.contains("--") || input.contains("**") || input.contains("//") || input.contains("^^")) {
            return true;
        }
        return false;
    }

    public boolean UnclosedParentheses(String input){
        int OPC = 0;
        int CPC = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                OPC++;
            } else if (c == ')') {
                CPC++;
            }
        }
        if (OPC != CPC) {
         
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
      
        return true;
    }

    public boolean noOperand(String input){
        String[] operands = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (String op : operands) {
            if (input.contains(op)) {
                return false;
            }
        }
      
        return true;
    }

    public boolean OperatorBeforeandAfterParentheses(String input){
        if (input.contains("()") || input.contains("(+") || input.contains("(*") 
        ||input.contains("(/") || input.contains("(^") || input.contains("+)") 
        || input.contains("-)") || input.contains("*)") || input.contains("/)") || input.contains("^)")) {
            
        }
        return false;

    }

    public boolean noOperatorBeforeParentheses(String input) {

        for (int i = 0; i < input.length(); i++) {
        if (input.charAt(i) == '(' && i > 0) {

            char before = input.charAt(i - 1);

            if (Character.isDigit(before) || before == ')') {
                return true;
            }
        }
        if (input.charAt(i) == ')' && i < input.length() - 1) {

            char after = input.charAt(i + 1);

            if (Character.isDigit(after) || after == '(') {
                return true;
            }
        }
    }

        return false;
    }


    public boolean DivisionByZero(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '/' && input.charAt(i + 1) == '0') {
              
                return true;
            }
        }
        return false;
    }

    public boolean startsWithOperator (String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*' || c == '/' || c == '^') {
                
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
              
                return true;
            } else if (Character.isDigit(c) || c == ')') {
                break;
            }
        }
        return false;
    }



    //0.50
    //11.20


    public boolean noFirstDecimalPlace (String input){
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(0);
            if (c == '.') {
                return true;

            }


        }
        return false;
    }

    public boolean twoDecimalPlaces(String input) {
        int decimalCount = 0;
        boolean decimalpoint = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                if (decimalpoint){
                    return true;
                } 
                decimalpoint =true;
               
            }else if (decimalpoint && Character.isDigit(c)){
                decimalCount++;
                if(decimalCount >2){
                    return true;
                }
            }
        }
        return false; 
    }


}

