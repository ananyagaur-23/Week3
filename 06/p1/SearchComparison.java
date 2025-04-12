import java.util.Arrays;
import java.util.Scanner;

public class SearchComparison{
    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] input = sc.nextLine().trim().split("\\s+");
        int[] data = new int[input.length];
        for(int i = 0; i<input.length;i++){
            data[i] = Integer.parseInt(input[i]);
        }
        System.out.println("Enter target to Search: ");
        int target = sc.nextInt();
        long start, end;

        start = System.nanoTime();
        int linearIndex = linearSearch(data, target);
        end = System.nanoTime();
        double linearTime = (end - start)/1e6;

        Arrays.sort(data);

        start = System.nanoTime();
        int binaryIndex = binarySearch(data, target);
        end = System.nanoTime();
        double binaryTime = (end - start)/1e6;

        System.out.println("Linear search index: "+linearIndex);
        System.out.printf("Linear search time: %.4f ms\n",linearTime);
        System.out.println("Binary search index: "+binaryIndex);
        System.out.printf("Binary search time: %.4f ms\n",binaryTime);
    }
}