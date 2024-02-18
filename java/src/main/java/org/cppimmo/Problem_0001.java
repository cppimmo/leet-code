package org.cppimmo;

public class Problem_0001 {
	public static void main(String[] args) {
		System.out.println("Test case 1: " + printArray(twoSum(new int[]{2, 7, 11, 15}, 9)));
		System.out.println("Test case 2: " + printArray(twoSum(new int[]{3, 2, 4}, 6)));
		System.out.println("Test case 3: " + printArray(twoSum(new int[]{3, 3}, 6)));
	}

	public static <T> String printArray(T[] array) {
		var result = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) {
			result.append(array[i].toString() + (i != (array.length - 1) ? ", " : ""));
		}
		return result.toString();
	}
	
    public static Integer[] twoSum(int[] nums, int target) {
        // Store indices at which the sum of the elements equals target
        int i1 = 0, i2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) // Ignore if i == j
                    continue;

                // Check the sum of the elements
                if ((nums[i] + nums[j]) == target) {
                    i1 = i; i2 = j; // Set the indices and stop iterating
                    break;
                }
            }
        }
        // Return array of indices
        return new Integer[]{i1, i2};
    }
}
