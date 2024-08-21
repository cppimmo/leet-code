class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        final int haystackLength = haystack.length(),
                  needleLength = needle.length();
        // No match possible if haystack length is short than that of the needle
        if (haystackLength < needleLength) {
            return -1;
        }
        // Index past where haystack can't possibly contain the needle
        final int stopIndex = haystackLength - needleLength;
        for (int i = 0; i <= stopIndex; i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                // Stop in the event of a mismatch (i + j is the appropriate offset for the haystack)
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;    
            }
            // Return the start index if all characters matched
            if (j == needleLength)
                return i;
        }
        return -1; // No match found
    }
}
