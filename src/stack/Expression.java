package stack;

import java.util.Stack;

public class Expression {
    public Boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty())
                    return false;
                Character top = stack.pop();
                if (isBracketNotMatch(top, ch))
                    return false;

            }

        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '<' || ch == '{' || ch == '[';
    }

    private boolean isRightBracket(char ch) {
        return ch == ')' || ch == '>' || ch == '}' || ch == ']';
    }

    private boolean isBracketNotMatch(char left, char right) {
        return right == ')' && left != '(' ||
                right == '>' && left != '<' ||
                right == '}' && left != '{' ||
                right == ']' && left != '[';

    }

}
