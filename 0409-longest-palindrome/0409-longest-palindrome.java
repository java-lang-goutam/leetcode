class Solution {
    public int longestPalindrome(String s) {
        
        final int[] freq = new int[52];
        for (int i=0, n = s.length(); i < n; i++) {
            final char c = s.charAt(i);
            if (c <='Z') freq[c - 'A']++;
            else freq[26 + c - 'a']++;
        }
        
        int result = 0;
        for (int i=0; i < 52; i++) {
            result += freq[i];
            if ((freq[i] & 1) == 1) result--;
        }
        
        return result == s.length() ? result : result + 1;
    }
}