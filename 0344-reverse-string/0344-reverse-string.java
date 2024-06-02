class Solution {
    public void reverseString(char[] s) {
        for (int i=0, n = s.length; i < (n >> 1); i++) {
            final char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }
}