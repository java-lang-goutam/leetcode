class Solution {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int solution = 0;
        final int kthValue = tickets[k];

        if (kthValue == 1) return k + 1;

        for (int i = 0, n = tickets.length; i < n; i++) {
            int val = tickets[i];
            solution += Math.min(val, i <= k ? kthValue : kthValue - 1);
        }

        return solution;
    }
}
