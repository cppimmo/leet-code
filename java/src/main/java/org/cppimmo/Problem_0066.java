import java.math.BigInteger;

class Solution {
    public int[] plusOne1(int[] digits) {
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

	public int[] plusOne2(int[] digits) {
        int carry = 1;
        // Begin iterating at the least significant digit
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += carry;
                carry = 0;
                break;
            } else
                digits[i] = 0;
        }

        if (carry > 0) {
            int[] newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, newDigits.length - 1);
            newDigits[0] = carry;
            return newDigits;
        }
        else
            return digits;
    }
}
