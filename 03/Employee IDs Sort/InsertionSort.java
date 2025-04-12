public class InsertionSort {
    public static void sortEmployeeIDs(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            ids[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {104, 102, 110, 101, 107};
        sortEmployeeIDs(employeeIDs);

        System.out.print("Sorted Employee IDs: ");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}
