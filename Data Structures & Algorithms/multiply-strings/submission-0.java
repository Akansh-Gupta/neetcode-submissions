class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int p1 = i + j;
                int p2 = i + j + 1;

                int product = digit1 * digit2 + result[p2];

                result[p2] = product % 10;

                result[p1] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int digit : result) {

            if (sb.length() == 0 && digit == 0) {
                continue;
            }

            sb.append(digit);
        }

        return sb.toString();
    }
}