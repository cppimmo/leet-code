class Solution {
    public int pivotIndex1(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int[] leftSums = new int[n], rightSums = new int[n];
        // Store sums to the rest (going in the increasing order of indexes will give the leftmost pivot)
        for (int i = 0; i < n; i++) {
            // Sum the left side prior to i
            for (int left = 0; left < i; left++)
                leftSums[i] += nums[left];
            // Sum the right side after i
            for (int right = i + 1; right < n; right++)
                rightSums[i] += nums[right];
        }

        for (int i = 0; i < n; i++) {
            // Return i if the left sum before and the right sum past the index are equal
            if (leftSums[i] == rightSums[i])
                return i;
        }
        return -1; // No leftmost pivot index
    }

	public int pivotIndex2(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int totalSum = 0, leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < n; i++) {
            // Return i if the left sum before and the right sum past the index are equal
            final int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1; // No leftmost pivot index
    }
}
