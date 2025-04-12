public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0;
        int currentPetrol = 0;
        int totalPetrol = 0;
        int totalDistance = 0;

        for (int i = 0; i < petrol.length; i++) {
            currentPetrol += petrol[i] - distance[i];
            totalPetrol += petrol[i] - distance[i];
            totalDistance += distance[i];

            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        return (totalPetrol >= totalDistance) ? start : -1;
    }
}
