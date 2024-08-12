class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) return nums;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean isEven = nums[i] % 2 == 0;
            if (isEven) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
