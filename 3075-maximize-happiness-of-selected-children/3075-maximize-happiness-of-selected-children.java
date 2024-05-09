class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int h : happiness) queue.offer(h);

        long sum = 0;
        int count = 0, newVal;
        while (k-- > 0 && !queue.isEmpty() && (newVal = queue.poll() - count++) > 0) {
            sum += newVal;
        }

        return sum;
    }
}
