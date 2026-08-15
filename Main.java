import java.util.*;
public class Main {
    public static void main(String[] args){


    
        Scanner sc=new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        CalPostfix calPostfix = new CalPostfix();
        InputValidation inputValidation = new InputValidation();
        System.out.print("Enter the infix expression: ");
        String input=sc.nextLine();
    

        inputValidation.endsWithOperator(input);
        inputValidation.withSpace(input);
        inputValidation.emptyParentheses(input);
        inputValidation.doubleOperator(input);
        inputValidation.UnclosedParentheses(input);
        inputValidation.noOperator(input);
        inputValidation.noOperand(input);
        inputValidation.OperatorBeforeandAfterParentheses(input);
        inputValidation.noOperatorBeforeParentheses(input);
        inputValidation.DivisionByZero(input);
        inputValidation.startsWithOperator(input);



        infixToPostfix.Tokenize(input);
        infixToPostfix.convert();

        System.out.println("Tokenized Expression: " + infixToPostfix.PostfixList);
        System.out.println("Results: " + calPostfix.CalPostfix(infixToPostfix.PostfixList));
    }
    
}
