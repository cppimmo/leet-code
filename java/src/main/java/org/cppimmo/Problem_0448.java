class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numbersInRange = new HashSet<>();
        for (int num : nums) {
            numbersInRange.add(num);
        }
        //numbersInRange.forEach(System.out::println);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numbersInRange.contains(i)) {
                //System.out.println(i + " is not in the range");
                result.add(i);
            }
        }
        return result;
    }
}
