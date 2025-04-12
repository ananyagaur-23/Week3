import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        StudentLinkedList list = new StudentLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add at the Start \n2. Add at the End \n3. Add at Position \n4.Delete by Roll Number \n5. Search by Roll Number \n6. Update Grade \n7. Display All \n8. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter Roll Number, Name, Age, Grade: ");
                    list.addAtStart(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                }
                case 2: {
                    System.out.println("Enter Roll Number, Name, Age, Grade: ");
                    list.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                }
                case 3: {
                    System.out.println("Enter Position, Roll Number, Name, Age, Grade: ");
                    list.addAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                }
                case 4: {
                    System.out.println("Enter Roll Number: ");
                    list.deleteRollNumber(sc.nextInt());
                    break;
                }
                case 5: {
                    System.out.println("Enter Roll Number: ");
                    list.searchByRollNumber(sc.nextInt());
                    break;
                }
                case 6: {
                    System.out.println("Enter Roll Number and new Grade: ");
                    list.updateGrade(sc.nextInt(), sc.next());
                    break;
                }
                case 7: {
                    list.displayAll();
                    break;
                }
                case 8: {
                    System.out.println("Already Exists");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
        while (choice != 8);
    }
}