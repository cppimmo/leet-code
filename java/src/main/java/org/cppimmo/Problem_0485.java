class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = 0;
        for (var num : nums) {
            currCount = (num == 1) ? (currCount + 1) : 0;
            maxCount = Math.max(currCount, maxCount);
        }
        return maxCount;
    }
}
