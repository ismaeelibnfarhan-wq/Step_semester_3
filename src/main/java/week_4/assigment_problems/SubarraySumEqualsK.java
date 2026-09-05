package main.java.week_4.assigment_problems;
import java.util.HashMap;
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1); 
        
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int[] nums2 = {1, -1, 0};
        int k2 = 0;

        System.out.println("Subarrays equal to K (1): " + subarraySum(nums1, k1)); 
        System.out.println("Subarrays equal to K (2): " + subarraySum(nums2, k2)); 
    }
}
