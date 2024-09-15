class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        // Find the maximum length of the two strings
        final int maxLength = Math.max(a.length(), b.length());
        // Pad both strings with leading zeros
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';
            int sum = digitA + digitB + carry;
            
            if (sum == 2) {
                result = '0' + result;  // 1 + 1 = 10, write 0, carry 1
                carry = 1;
            } else if (sum == 3) {
                result = '1' + result;  // 1 + 1 + 1 = 11, write 1, carry 1
                carry = 1;
            } else {
                result = (sum % 2) + result;  // Write the result (0 or 1)
                carry = 0;
            }
        }
        // Check for final carry digit
        if (carry == 1) {
            result = '1' + result; // Prepend the final carry digit
        }
        return result;
    }
}
