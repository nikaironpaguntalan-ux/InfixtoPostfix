import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.print("Enter the infix expression: ");
        String input=sc.nextLine();

        infixToPostfix.Tokenize(input);
        infixToPostfix.convert();

        System.out.println("Tokenized Expression: " + infixToPostfix.PostfixList);

    }
    
}
