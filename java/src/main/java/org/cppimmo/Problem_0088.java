class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1; // Markers to the end of nums1 & nums2
        for (int i = (m + n - 1); i >= 0; --i) {
            if (p2 < 0) break; // Elements in nums2 have been merged

            if (p1 >= 0 && nums1[p1] > nums2[p2])
                nums1[i] = nums1[p1--];
            else
                nums1[i] = nums2[p2--];
        }
    }
}
