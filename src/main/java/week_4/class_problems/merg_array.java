import java.util.Arrays;

public class merg_array {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5};
		int[] arr2 = {2, 4, 6};

		int[] result = mergeSortedArrays(arr1, arr2);

		System.out.println(Arrays.toString(result));
	}

	public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int index1 = 0;
		int index2 = 0;
		int resultIndex = 0;

		while (index1 < arr1.length && index2 < arr2.length) {
			if (arr1[index1] < arr2[index2]) {
				result[resultIndex] = arr1[index1];
				index1++;
			} else {
				result[resultIndex] = arr2[index2];
				index2++;
			}
			resultIndex++;
		}

		while (index1 < arr1.length) {
			result[resultIndex] = arr1[index1];
			index1++;
			resultIndex++;
		}

		while (index2 < arr2.length) {
			result[resultIndex] = arr2[index2];
			index2++;
			resultIndex++;
		}

		return result;
	}
}