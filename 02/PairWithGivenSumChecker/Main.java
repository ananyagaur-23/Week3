import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target sum: ");
        int target = sc.nextInt();
        boolean result = FindPairWithGivenSum.hasPairWithSum(arr, target);
        if (result) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No pair with given sum.");
        }
    }
}
