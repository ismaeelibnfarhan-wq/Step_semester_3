package week_4.class_problems;

public class duplicate {
    public static boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true; // Duplicate found
                }
            }
        }
        return false; // No duplicates found
    }    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1};
        boolean hasDuplicate = containsDuplicate(nums);
        System.out.println("Contains duplicate: " + hasDuplicate);
    }
}
