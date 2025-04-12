import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack:");
        Recursion.printStack(stack);

        Recursion.sortStack(stack);

        System.out.println("\nSorted Stack:");
        Recursion.printStack(stack);
    }
}
