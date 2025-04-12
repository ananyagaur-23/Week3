import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class DataStructureSearchComparison{
    public static boolean arraySearch(int[] arr, int target){
        for(int num : arr){
            if(num == target)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        int size = 1_000_000;
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        Random rand = new Random();
        for(int i = 0; i<size; i++){
            int val = rand.nextInt(size*2);
            array[i] = val;
            hashSet.add(val);
            treeSet.add(val);
        }
        int target = array[size/2];
        long start, end;

        start = System.nanoTime();
        boolean arrFound = arraySearch(array, target);
        end = System.nanoTime();
        System.out.printf("Array Search Time: %.2f ms\n", (end - start) / 1e6);

        start = System.nanoTime();
        boolean hashFound = hashSet.contains(target);
        end = System.nanoTime();
        System.out.printf("HashSet Search Time: %.2f ms\n", (end - start) / 1e6);

        start = System.nanoTime();
        boolean treeFound = treeSet.contains(target);
        end = System.nanoTime();
        System.out.printf("TreeSet Search Time: %.2f ms\n", (end - start) / 1e6);
    }
}