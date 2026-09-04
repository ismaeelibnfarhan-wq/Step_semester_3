public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int k = 2;

		int[] result = rotateArray(nums, k);

		for (int number : result) {
			System.out.print(number + " ");
		}
	}

	public static int[] rotateArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}

		k %= nums.length;
		int[] rotated = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			rotated[(i + k) % nums.length] = nums[i];
		}

		return rotated;
	}
}
