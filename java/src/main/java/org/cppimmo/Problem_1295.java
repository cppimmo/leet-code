class Solution {
    public int findNumbers(int[] nums) {
        Function<Integer, Integer> countDigits = (number) -> {
            if (number == 0) return 1;
            return (int)(Math.floor(Math.log10(number))) + 1;
        };
        int countOfEvenDigits = 0;
        for (int num : nums) {
            int digitCount = countDigits.apply(num);
            //System.out.printf("num = %d, digit count = %d\n", num, digitCount);
            if (digitCount % 2 == 0)
                countOfEvenDigits++;
        }
        return countOfEvenDigits;
    }
}
