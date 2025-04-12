import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class FindSubarrayWithZeroSum {

    public static List<List<Integer>> findSubarray(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                List<Integer> subarray = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            }

            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int index : indices) {
                    List<Integer> subarray = new ArrayList<>();
                    for (int j = index + 1; j <= i; j++) {
                        subarray.add(arr[j]);
                    }
                    result.add(subarray);
                }
            }

            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }

        return result;
    }
}
