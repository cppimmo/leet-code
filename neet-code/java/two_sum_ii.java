class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // [1, 2, 3, 4] Target = 3
        // No hashing
        // No nested for loops
        // Constant space complexity O(1)
        // 1-indexed
        // Two-pointer approach
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target)
                break;
            else {
                // Compare with sum instead of n[l] & n[r], because numbers is sorted
                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
