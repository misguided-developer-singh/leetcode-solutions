import java.util.Stack;

public class DecodeString {
    public static String decodeString(String str) {
        if(str == null || str.length() == 0) return "";

        Stack<Object> stack = new Stack<>();
        int number = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(Integer.valueOf(number));
                number = 0;
            } else if (ch == ']') {
                String s = popStack(stack);
                int num = (int) stack.pop();
                for(int i = 0; i < num; i++) stack.push(s);
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return popStack(stack);
    }

    private static String popStack(Stack<Object> stack) {
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
