class Solution {
    public boolean isPalindrome(String s) {
        int f = 0, r = s.length() - 1;
        while (f < r) {
            if (!Character.isLetterOrDigit(s.charAt(f))) {
                f++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(r)))
                return false;
            f++; r--;
        }
        return true;
    }
}
