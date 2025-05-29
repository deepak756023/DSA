package stack;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {

        String str = "abcd";
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
// String vs StringBuffer
// 1.String:Immutable
// Once created,the contents of a String cannot be changed.Any modification
// (e.g., concatenation) creates a new String object.
// StringBuffer:Mutable
// You can modify thecontents (append, insert, delete, etc.) without creating a
// new object.

// 2. Performance
// String:Slower forfrequent modifications (e.g., in loops) because it creates
// new objects each time.
// StringBuffer: Faster for frequent changes because it's mutable and doesn't
// create new objects.