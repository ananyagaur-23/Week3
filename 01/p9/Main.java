import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketCircularList system = new TicketCircularList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    
                    1. Book Ticket
                    2. Cancel Ticket
                    3. Display All Tickets
                    4. Search Ticket by Customer/Movie
                    5. Total Booked Tickets
                    6. Exit
                    """);
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                }
                case 2 -> {
                    System.out.print("Enter Ticket ID to cancel: ");
                    int id = sc.nextInt();
                    system.removeTicket(id);
                }
                case 3 -> system.displayAllTickets();
                case 4 -> {
                    System.out.print("Enter Customer Name or Movie Name: ");
                    String keyword = sc.nextLine();
                    system.searchByCustomerOrMovie(keyword);
                }
                case 5 -> System.out.println("Total Booked Tickets: " + system.totalTickets());
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 6);
    }
}
