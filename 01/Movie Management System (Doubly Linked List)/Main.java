import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Movie Management System =====");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movies by Director");
            System.out.println("6. Search Movies by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies (Forward)");
            System.out.println("9. Display Movies (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: {
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    String title = sc.nextLine();
                    String director = sc.nextLine();
                    int year = sc.nextInt();
                    double rating = sc.nextDouble();
                    movieList.addAtStart(title, director, year, rating);
                    break;
                }
                case 2: {
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    String title = sc.nextLine();
                    String director = sc.nextLine();
                    int year = sc.nextInt();
                    double rating = sc.nextDouble();
                    movieList.addAtEnd(title, director, year, rating);
                    break;
                }
                case 3: {
                    System.out.print("Enter Position, Title, Director, Year, Rating: ");
                    int pos = sc.nextInt();
                    sc.nextLine(); // consume newline
                    String title = sc.nextLine();
                    String director = sc.nextLine();
                    int year = sc.nextInt();
                    double rating = sc.nextDouble();
                    movieList.addAtPosition(pos, title, director, year, rating);
                    break;
                }
                case 4: {
                    System.out.print("Enter Movie Title to Remove: ");
                    String title = sc.nextLine();
                    movieList.removeByTitle(title);
                    break;
                }
                case 5: {
                    System.out.print("Enter Director Name: ");
                    String director = sc.nextLine();
                    movieList.searchByDirector(director);
                    break;
                }
                case 6: {
                    System.out.print("Enter Rating to Search: ");
                    double rating = sc.nextDouble();
                    movieList.searchByRating(rating);
                    break;
                }
                case 7: {
                    System.out.print("Enter Movie Title and New Rating: ");
                    String title = sc.nextLine();
                    double rating = sc.nextDouble();
                    movieList.updateRating(title, rating);
                    break;
                }
                case 8: {
                    System.out.println("\n--- Movie List (Forward) ---");
                    movieList.displayForward();
                    break;
                }
                case 9: {
                    System.out.println("\n--- Movie List (Reverse) ---");
                    movieList.displayReverse();
                    break;
                }
                case 10: {
                    System.out.println("Exiting Movie Management System.");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }

        } while (choice != 10);

        sc.close();
    }
}
