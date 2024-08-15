class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> topThree = new TreeSet<>();
        for (int num : nums) {
            topThree.add(num);
            if (topThree.size() > 3)
                topThree.pollFirst();
        }
        //topThree.forEach(v -> System.out.println(v));
        if (topThree.size() == 3)
            return topThree.first();
        else
            return topThree.last();
    }
}
