package org.cppimmo;

import java.util.*;

class Problem_0080 {
	public static void main(String[] args) {
		var solution = new Problem_0080();
	}
	
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pointer = 1; // Length of the final result
        int count = 1; // Count the consecutive occurrences of the current number
        // Start at index 1 to compare previous elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++; // Increment count (equal adjacent elements)
            else
                count = 1; // Reset count (differing adjacent elements)
            // Replace the element if the consecutive occurences of the current number is less than or equal to 2
            if (count <= 2) {
                nums[pointer] = nums[i];
                pointer++; // Increment the length/index
            }
        }
        return pointer;
    }
}
