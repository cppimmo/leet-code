import java.util.*;

class Problem_0680 {
	public static void main(String[] args) {
		System.out.println("aba: " + validPalindrome("aba"));
		System.out.println("abca: " + validPalindrome("abca"));
		System.out.println("abc: " + validPalindrome("abc"));
	}
	
    public static boolean validPalindrome(String s) {
		boolean atLeastOne = false;
		var charsRemoved = removeOneChar(s); // Create combinations
		for (var str : charsRemoved) {
			// One substring with a char removed was a palindrome
			if (isPalindrome(str)) {
				atLeastOne = true;
				break;
			}
		}
        return atLeastOne;
    }
	// Check if s is a palindrome.
	public static boolean isPalindrome(String s) {
		int low = 0, high = s.length() - 1; // Check entire string
		boolean result = true;
		while (low < high) {
			// If current start and end characters are not the same, then not palindromic
			if (s.charAt(low) != s.charAt(high)) {
				result = false;
				break;
			}
			low++; // Adjust lower bound
			high--; // Adjust upper bound
		}
		return result;
	}
	// Return all combinations of s with one character removed.
    public static List<String> removeOneChar(String s) {
        var result = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
			// Add substrings of s surrounding but not including the character at index i
			result.add(s.substring(0, i) + s.substring(i + 1, s.length()));
        }
        return result;
    }
}
