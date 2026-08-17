import java.util.*;
public class Main {
    public static void main(String[] args){


    
        Scanner sc =new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        CalPostfix calPostfix = new CalPostfix();
        InputValidation inputValidation = new InputValidation();
        while(true){
        System.out.println();
        System.out.print("Enter the infix expression: ");
        String input=sc.nextLine();

        if (inputValidation.withSpace(input) || inputValidation.invalidChars(input) || inputValidation.emptyParentheses(input) 
        || inputValidation.doubleOperator(input)|| inputValidation.UnclosedParentheses(input) || inputValidation.noOperator(input)
        || inputValidation.OperatorBeforeandAfterParentheses(input) || inputValidation.DivisionByZero(input) || inputValidation.noOperand(input)
        || inputValidation.noOperatorBeforeParentheses(input)|| inputValidation.startsWithOperator(input)
        || inputValidation.endsWithOperator(input) ||inputValidation.noFirstDecimalPlace(input)|| inputValidation.twoDecimalPlaces(input)) {
            System.out.println();
            System.out.println("   Please enter a valid infix expression.");
            System.out.println("-----------------------------------------");
            continue;
        }


        
      


        infixToPostfix.Tokenize(input);
        infixToPostfix.convert();

        System.out.println();
        System.out.println("Tokenized Expression: " + infixToPostfix.PostfixList);
        System.out.println("Result: " + calPostfix.CalPostfix(infixToPostfix.PostfixList));
        }
    }
    
}
