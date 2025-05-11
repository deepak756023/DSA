package stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {

        String str = "abcd";
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        // for (int i = 0; i < str.length(); i++)
        // stack.push(str.charAt(i));
        for (char ch : str.toCharArray())// forEach loop
            stack.push(ch);

        // String reversed = "";
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            // reversed += stack.pop();
            reversed.append(stack.pop());

        System.out.println(reversed.toString());

    }

}
