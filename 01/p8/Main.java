import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditorHistory editor = new TextEditorHistory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    
                    1. Type New Text
                    2. Undo
                    3. Redo
                    4. Show Current Text
                    5. Exit
                    """);
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new text: ");
                    String newText = sc.nextLine();
                    editor.addState(newText);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrentState();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }
}
