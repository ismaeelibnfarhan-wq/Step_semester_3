package main.java.week_4.assigment_problems;

public class MaximumSubarray {
    maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {-3, -1, -2};

        System.out.println("Max Subarray Sum 1: " + maxSubArray(nums1)); 
        System.out.println("Max Subarray Sum 2: " + maxSubArray(nums2)); 
    }
}
