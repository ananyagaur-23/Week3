import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management Menu =====");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title, Author, Genre, ID, Available(true/false): ");
                    lib.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                }
                case 2 -> {
                    System.out.print("Enter Title, Author, Genre, ID, Available(true/false): ");
                    lib.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                }
                case 3 -> {
                    System.out.print("Enter Position, Title, Author, Genre, ID, Available(true/false): ");
                    int pos = sc.nextInt(); sc.nextLine();
                    lib.addAtPosition(pos, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                }
                case 4 -> {
                    System.out.print("Enter Book ID to remove: ");
                    lib.removeById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Title to search: ");
                    lib.searchByTitle(sc.nextLine());
                }
                case 6 -> {
                    System.out.print("Enter Author to search: ");
                    lib.searchByAuthor(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Enter Book ID and Availability(true/false): ");
                    lib.updateAvailability(sc.nextInt(), sc.nextBoolean());
                }
                case 8 -> lib.displayForward();
                case 9 -> lib.displayReverse();
                case 10 -> lib.countBooks();
                case 11 -> System.out.println("Exiting Library System...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 11);
    }
}
