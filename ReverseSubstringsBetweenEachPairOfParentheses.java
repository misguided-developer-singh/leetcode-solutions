import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static String reverseParentheses(String str) {
         Stack<Character> stack = new Stack<>();

         for(char ch : str.toCharArray()) {
             // When we encounter a closing parenthesis, start popping until we find the opening parenthesis '('
            if(ch == ')') {

                StringBuilder sb = new StringBuilder();
                // Pop characters inside the parentheses
                while(stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                // Pop the '(' character itself
                stack.pop();

                // Push the reversed substring back to the stack
                for(char c : sb.toString().toCharArray()) {
                    stack.push(c);
                }
            } else {
                stack.push(ch);
            }
         }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        System.out.println(stack);
         while(!stack.isEmpty()) {
             result.insert(0, stack.pop());
         }
        return result.toString();
    }

    public static void main(String[] args) {
//        String s = "(abc(def)gh)";
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}
