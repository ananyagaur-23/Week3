import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> zeroSumSubarray = FindSubarrayWithZeroSum.findSubarray(arr);
        System.out.println("\nZero sum subarrays:-");
        for (List<Integer> subarray : zeroSumSubarray) {
            System.out.println(subarray);
        }
    }
}
