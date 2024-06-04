class Solution {
    public int longestPalindrome(String s) {
        
        final int[] freq = new int[52];
        int result = 0;
        for (int i=0, n = s.length(); i < n; i++) {
            final char c = s.charAt(i);
            final int index;
            if (c > 'Z') index = 26 + c - 'a';
            else index = c - 'A';

            if ((++freq[index] & 1) == 0) result += 2;
        }
        
        return result == s.length() ? result : result + 1;
    }
}