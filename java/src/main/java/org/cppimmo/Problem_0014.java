package org.cppimmo;

import java.util.*;

class Problem_0014 {
    public static void main(String[] args) {
        System.out.println("Example 1: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("Example 2: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        // List of all possible non-empty prefixes of all strings in strs
        List<String> prefixes = new ArrayList<>(strs.length);

        for (var s : strs) {
            for (int i = 1; i < (s.length() + 1); i++)
                prefixes.add(s.substring(0, i));
        }
        // Sorting is needed for finding the longest prefix
        Map<String, Integer> occurrences = new TreeMap<>(Comparator.comparing(String::length).reversed());
        prefixes.forEach(e -> occurrences.put(e, 0)); // Add prefixes to occurrences map with initial counts
        prefixes.forEach(prefix -> {
            // Now count the number of occurrences for each prefix
            occurrences.put(prefix, occurrences.get(prefix) + 1);
        });
        // Set default value to empty string in case there is no common prefix
        Map.Entry<String, Integer> maxEntry = new AbstractMap.SimpleEntry<>("", 0);
        for (var entry : occurrences.entrySet()) {
            // Check if the current prefix is common to every string
            boolean inEveryString = true;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].contains(entry.getKey())) {
                    inEveryString = false;
                    break;
                }
            }
            // Check if the longest prefix should be updated
            if (inEveryString && (entry.getValue() > maxEntry.getValue())) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}