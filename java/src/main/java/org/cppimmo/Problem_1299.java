class Solution {
    public int[] replaceElements(int[] arr) {
        final int N = arr.length;
        int max = -1; // Keep track of the max element
        for (int i = N - 1; i >= 0; --i) { // Start at the end
            int curr = arr[i];
            // Replace with the current max element to the right of the current element
            arr[i] = max;
            // Update the max element
            max = Math.max(max, curr);
        }
        return arr;
    }
}
