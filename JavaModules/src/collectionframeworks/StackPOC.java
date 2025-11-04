package collectionframeworks;
import java.util.*;

public class StackPOC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Real Stack Calculator!");
        System.out.println("Enter full expressions (like 3+5*2 or (10+2)*3). \nType 'exit' to quit.");

        while (true) {
            System.out.print("\nExpression: ");
            String expression = sc.nextLine().trim();

            if (expression.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Calculator... 👋");
                break;
            }

            try {
                int result = evaluateExpression(expression);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid Expression! Please try again.");
            }
        }
        sc.close();
    }

    private static int evaluateExpression(String exp) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    num = num * 10 + (exp.charAt(i) - '0');
                    i++;
                }
                i--; 
                values.push(num);
            }
            else if (ch == '(') {
                operators.push(ch);
            }
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); 
            }
            else if (isOperator(ch)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) {
                    System.out.println("Division by zero! Returning 0.");
                    return 0;
                }
                return a / b;
        }
        return 0;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}
