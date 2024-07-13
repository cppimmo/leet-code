class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answers = new ArrayList<String>(n);

        for (int i = 1; i <= n; ++i) {
            boolean divisibleBy3 = isDivisibleBy(i, 3);
            boolean divisibleBy5 = isDivisibleBy(i, 5);

            String newAnswer = Integer.toString(i); // Default answer to i
            if (divisibleBy3 && divisibleBy5)
                newAnswer = "FizzBuzz";
            else if (divisibleBy3)
                newAnswer = "Fizz";
            else if (divisibleBy5)
                newAnswer = "Buzz";

            answers.add(newAnswer);
        }
        return answers;
    }

    private static boolean isDivisibleBy(int numerator, int denominator) {
        return (numerator % denominator) == 0;
    }
}
