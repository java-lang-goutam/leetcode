class Solution {

    private int[] dp;

    public int racecar(int target) {
        this.dp = new int[target+1];
        return dfs(target);
    }

    private int dfs(int target) {

        if (dp[target] != 0) return dp[target];

        int n = getPow(target);

        // case 1 : (best case) all accelerate
        if (pow2(n)-1 == target) {
            dp[target] = n;
            return n;
        }

        // case 2 : overshoot the target and come back and accelrate to reach remaining position
        dp[target] = 1 + n + dfs(pow2(n)-1-target); // n to reach overshoot position and 1 for taking reverse

        // case 3 : The car reaches 2^(n-1) - 1 and then reverses, accelerates for another A^j in the opposite direction and 
        // reverses again. Now its position is at 2^(r-1) - 2^j, the remaining subproblem is to go from current position to i with
        // initial speed, which is dp[target-2^(n-1)+2^j].
        // so no of steps will be (n-1) + 1 to reach n-1, 1 step to reverse, j step to accelerate, 1 step to reverse again
        for (int j=0; j<n-1; j++) {
            dp[target] = Math.min(dp[target], 1 + n + j + dfs(target - pow2(n-1) + pow2(j)));
        }

        return dp[target];
    }

    private int pow2(int n) {
        return 1<<n;
    }

    private int getPow(int target) {
        return ((int) (Math.log(target) / Math.log(2))) + 1;
    }
}
