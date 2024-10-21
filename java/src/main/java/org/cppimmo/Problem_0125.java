class Solution {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            char chLow = Character.toLowerCase(s.charAt(low));
            char chHigh = Character.toLowerCase(s.charAt(high));
			// Skip non letter/digit characters
            if (!Character.isLetterOrDigit(chLow)) {
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(chHigh)) {
                high--;
                continue;
            }
            if (chLow != chHigh)
                    return false;
			// Move the pointers towards the center
            low++;
            high--;
        }
        return true;
    }
}
