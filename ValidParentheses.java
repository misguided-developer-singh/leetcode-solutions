import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()) {
            if(ch == '(')
                stack.push(')');
            else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidV2(String str) {
        // Continue until no more valid pairs can be found
        while(str.contains("()") || str.contains("[]") || str.contains("{}")) {
            // Remove valid pairs
            str = str.replace("()", "");
            str = str.replace("[]", "");
            str = str.replace("{}", "");
        }
        // If the string is empty, then it is valid, otherwise invalid
        return str.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("([)]")); // false
        System.out.println(isValidV2("()[]{}")); // true
        System.out.println(isValidV2("([)]")); // false
    }
}
