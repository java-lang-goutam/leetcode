/**
Please upvote :)
Credit - https://www.geeksforgeeks.org/digit-dp-introduction/
https://youtu.be/GnFM1A7-q7c?si=IKbXjZ4DM6HTYsyk
*/
class Solution {
    // 0 - index position
    // 1 - count of 1s present
    // 2 - tight
    private Integer[][][] digitDp = null;
    private String num = null;

    private int solve(final int index, final int count, final int tight) {
        if (index == num.length()) return count;

        if (digitDp[index][count][tight] != null) {
            return digitDp[index][count][tight];
        }

        final int limit = (tight == 0) ? 9 : num.charAt(index) - '0';

        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            final int newCount = (i == 1) ? count + 1 : count;
            final int newTight = (tight == 0) ? 0 : ((i == limit) ? 1 : 0);
            ans += solve(index + 1, newCount, newTight);
        }

        return digitDp[index][count][tight] = ans;
    }

    public int countDigitOne(int n) {
        this.num = String.valueOf(n);
        this.digitDp = new Integer[num.length()][num.length()][2];
        return solve(0, 0, 1);
    }
}
