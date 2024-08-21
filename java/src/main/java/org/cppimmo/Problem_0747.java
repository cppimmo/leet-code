class Solution {
    private record Pair<F, S>(F first, S second) {}

    public int dominantIndex(int[] nums) {
        // Find the largest unique number and its index
        int maxNum = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }

        for (int num : nums) {
            // maxNum should be greater than or equal to double the current number
            if (num != maxNum && maxNum < (2 * num))
                return -1;
        }
        return maxIndex;
    }
}
