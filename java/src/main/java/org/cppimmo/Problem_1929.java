
class Solution {
    private static java.io.PrintStream ps = System.out;
    public int[] getConcatenation(int[] nums) {
        final int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; ++i) {
            //ps.println(i + " : " + (n - i));
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}

