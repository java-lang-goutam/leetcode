class Solution {

    public boolean isMatch(final String s, final String p) {
        final Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return check(dp, s, p, 0, 0);
    }

    private boolean check(final Boolean[][] dp, final String s, final String p, final int sIndex, final int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        if (sIndex > s.length()) return false;

        if (dp[sIndex][pIndex] != null) return dp[sIndex][pIndex];

        final boolean ans;
        final boolean singleMatch = (sIndex < s.length()) && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?');

        if (singleMatch) {
            ans = check(dp, s, p, sIndex + 1, pIndex + 1);
        } else if (p.charAt(pIndex) == '*') {
            ans = check(dp, s, p, sIndex, pIndex + 1) || check(dp, s, p, sIndex + 1, pIndex);
        } else ans = false;

        return dp[sIndex][pIndex] = ans;
    }
}
