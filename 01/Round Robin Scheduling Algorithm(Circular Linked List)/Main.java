import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Round Robin Scheduler Menu ===");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Run Round Robin Simulation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Process ID, Burst Time, and Priority: ");
                    scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                }
                case 2 -> scheduler.displayProcesses();
                case 3 -> {
                    System.out.print("Enter Time Quantum: ");
                    scheduler.simulate(sc.nextInt());
                }
                case 4 -> System.out.println("Exiting Scheduler...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
