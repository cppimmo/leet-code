class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return; // No extra elements to move

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // If i is non-zero, move i to write pointer j and advance j
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        // Replace elements after j with zero
        for (; j < nums.length; nums[j++] = 0);
    }
}
