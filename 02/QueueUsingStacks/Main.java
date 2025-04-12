import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    
                    1. Enqueue
                    2. Dequeue
                    3. Peek
                    4. Check if Empty
                    5. Exit
                    """);
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                }
                case 2 -> System.out.println("Dequeued: " + queue.dequeue());
                case 3 -> System.out.println("Front: " + queue.peek());
                case 4 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
