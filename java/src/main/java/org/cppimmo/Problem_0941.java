class Solution {
    public boolean validMountainArray(int[] arr) {
        final int N = arr.length;
        if (N < 3) {
            return false;
        }
        int i = 0;
        for (; (i + 1 < N) && arr[i] < arr[i + 1]; ++i);
        if (i == 0 || i == N - 1) {
            return false;
        }
        for (; (i + 1 < N) && arr[i] > arr[i + 1]; ++i);
        return (i == N - 1);
    }
}
