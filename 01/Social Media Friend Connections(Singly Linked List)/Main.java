import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FriendNetwork network = new FriendNetwork();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    
                    1. Add User
                    2. Add Friend Connection
                    3. Remove Friend Connection
                    4. Display Friends of User
                    5. Find Mutual Friends
                    6. Search User by ID
                    7. Search User by Name
                    8. Count Friends for Each User
                    9. Display All Users
                    10. Exit
                    """);

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID, Name, Age: ");
                    network.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter two User IDs to connect as friends: ");
                    network.addFriend(sc.nextInt(), sc.nextInt());
                }
                case 3 -> {
                    System.out.print("Enter two User IDs to remove connection: ");
                    network.removeFriend(sc.nextInt(), sc.nextInt());
                }
                case 4 -> {
                    System.out.print("Enter User ID to display friends: ");
                    network.displayFriends(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter two User IDs to find mutual friends: ");
                    network.findMutualFriends(sc.nextInt(), sc.nextInt());
                }
                case 6 -> {
                    System.out.print("Enter User ID to search: ");
                    network.searchUserById(sc.nextInt());
                }
                case 7 -> {
                    System.out.print("Enter Name to search: ");
                    network.searchUserByName(sc.next());
                }
                case 8 -> network.countFriends();
                case 9 -> network.displayAllUsers();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 10);
    }
}
