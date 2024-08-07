class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            // Move the elements that are not equal to val to the front of the array
            // Increment the new length by 1
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }
}
