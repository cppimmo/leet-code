import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        return intToDigits(digitsToInt(digits).add(BigInteger.ONE));
    }

    public static BigInteger digitsToInt(int[] digits) {
        StringBuilder str = new StringBuilder(digits.length);
        for (int digit : digits) {
            str.append(digit);
        }
        return new BigInteger(str.toString());
    }

    public static int[] intToDigits(BigInteger number) {
        String numStr = number.toString();
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char)(numStr.charAt(i) - '0');
        }
        return digits;
    }
}
