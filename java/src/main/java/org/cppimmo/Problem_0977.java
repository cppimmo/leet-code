class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length, left = 0, right = len - 1;
        int[] squares = new int[len];

        for (int i = len - 1; i >= 0; --i) {
            int leftNum = nums[left],
                rightNum = nums[right];
            if (Math.abs(leftNum) > Math.abs(rightNum)) {
                squares[i] = (leftNum * leftNum); 
                left++;
            } else {
                squares[i] = (rightNum * rightNum);
                right--; 
            }
        }
        return squares;
    }
}
