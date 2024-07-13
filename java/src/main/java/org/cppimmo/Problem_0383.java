class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> charCounts =  new HashMap<>();
        for (int i = 0; i < magazine.length(); ++i) {
            var currentChar = magazine.charAt(i);
            charCounts.put(currentChar, charCounts.getOrDefault(currentChar, 0) + 1);
        }
        /*charCounts.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });*/
        for (int i = 0; i < ransomNote.length(); ++i) {
            var currentChar = ransomNote.charAt(i);
            int currentCount = 0;
            if ((currentCount = charCounts.getOrDefault(currentChar, 0)) == 0)
                return false;

            charCounts.put(currentChar, currentCount - 1);
        }
        return true;
    }
}
