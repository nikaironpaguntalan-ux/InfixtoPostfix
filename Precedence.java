public class Precedence {

    public static int getPrecedence(char operator) {
          if(operator == '+' || operator == '-') {
                return 1;
            } else if (operator == '*' || operator == '/') {
                return 2;
            } else if (operator == '^') {
                return 3;
            } else {
                return -1;
            }
        
    }


    
}
