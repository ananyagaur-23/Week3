import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Inventory Management Menu =====");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    inventory.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                }
                case 2 -> {
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    inventory.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter Position, Name, ID, Quantity, Price: ");
                    inventory.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                }
                case 4 -> {
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Item ID and new quantity: ");
                    inventory.updateQuantity(sc.nextInt(), sc.nextInt());
                }
                case 6 -> {
                    System.out.print("Enter Item ID to search: ");
                    inventory.searchById(sc.nextInt());
                }
                case 7 -> {
                    System.out.print("Enter Item Name to search: ");
                    inventory.searchByName(sc.nextLine());
                }
                case 8 -> inventory.displayAll();
                case 9 -> inventory.totalValue();
                case 10 -> {
                    System.out.print("Sort Ascending? (true/false): ");
                    inventory.sortBy("name", sc.nextBoolean());
                }
                case 11 -> {
                    System.out.print("Sort Ascending? (true/false): ");
                    inventory.sortBy("price", sc.nextBoolean());
                }
                case 12 -> System.out.println("Exiting Inventory Management System...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 12);

        sc.close();
    }
}
