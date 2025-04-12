public class Main {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int startPoint = CircularTour.findStartingPoint(petrol, distance);

        if (startPoint == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("The tour can be started at pump: " + startPoint);
        }
    }
}
