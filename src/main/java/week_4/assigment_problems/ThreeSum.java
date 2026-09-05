package main.java.week_4.assigment_problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {public static int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++; 
                } else {
                    right--; 
                }
            }
        }
        
        return resultList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0};

        System.out.println("3Sum Output 1: " + Arrays.deepToString(threeSum(nums1))); 
        System.out.println("3Sum Output 2: " + Arrays.deepToString(threeSum(nums2))); 
    }
    
}
