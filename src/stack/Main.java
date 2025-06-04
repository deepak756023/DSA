package stack;

public class Main {
    public static void main(String[] args) {

        // String str = "((1 + <2>[]))";
        // Expression exp = new Expression();
        // var result = exp.isBalanced(str);
        // System.out.println(result);

        // CustomStack stack = new CustomStack();
        // stack.push(10);
        // stack.push(0);
        // stack.push(30);
        // stack.push(40);
        // stack.pop();
        // stack.pop();

        // System.out.println(stack);
        // System.out.println(stack.peek());

        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        minStack.push(40);
        System.out.println(minStack.min());

    }

}
