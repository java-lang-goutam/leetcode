class Solution {

    public boolean checkValidString(String s) {
        final Boolean[][] dp = new Boolean[s.length()][s.length()];
        return check(dp, s, 0, 0);
    }

    private boolean check(final Boolean[][] dp, final String s, final int index, final int count) {
        if (count < 0) return false;

        if (index == s.length()) {
            return count == 0;
        }

        if (dp[index][count] != null) return dp[index][count];

        final char current = s.charAt(index);

        final boolean ans;

        if (current == '(') ans = check(dp, s, index + 1, count + 1); 
        else if (current == ')') ans = check(dp, s, index + 1, count - 1);
        else ans = check(dp, s, index + 1, count) || 
            check(dp, s, index + 1, count + 1) || 
            check(dp, s, index + 1, count - 1);

        return dp[index][count] = ans;
    }
}
