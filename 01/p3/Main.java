import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Task Scheduler Menu =====");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    scheduler.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    scheduler.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.print("Enter Position, ID, Name, Priority, Due Date: ");
                    scheduler.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    scheduler.removeById(sc.nextInt());
                    break;
                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;
                case 6:
                    scheduler.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Priority to Search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;
                case 8:
                    System.out.println("Exiting Task Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
