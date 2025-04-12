import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIdx = partition(arr, low, high);
            quickSort(arr, low, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++)
                original[i] = rand.nextInt(size * 2);

            System.out.println("Dataset Size: " + size);

            if (size <= 10000) {
                int[] bubbleData = Arrays.copyOf(original, original.length);
                long start = System.nanoTime();
                bubbleSort(bubbleData);
                long end = System.nanoTime();
                System.out.printf("Bubble Sort Time: %.2f ms\n", (end - start) / 1e6);
            } else {
                System.out.println("Bubble Sort Time: Skipped (too large)");
            }

            int[] mergeData = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            mergeSort(mergeData);
            long end = System.nanoTime();
            System.out.printf("Merge Sort Time: %.2f ms\n", (end - start) / 1e6);

            int[] quickData = Arrays.copyOf(original, original.length);
            start = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            end = System.nanoTime();
            System.out.printf("Quick Sort Time: %.2f ms\n\n", (end - start) / 1e6);
        }
    }
}
