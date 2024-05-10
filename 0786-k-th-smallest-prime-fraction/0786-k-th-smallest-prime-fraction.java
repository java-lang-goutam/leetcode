class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                return Double.compare(1.0 * arr[a[0]] / arr[a[1]], 1.0 * arr[b[0]] / arr[b[1]]);
            }
        );

        for (int i = 0; i < arr.length - 1; i++) {
            pq.offer(new int[] { i, arr.length - 1 });
        }

        while (--k > 0) {
            final int[] ele = pq.poll();
            ele[1]--;
            pq.offer(ele);
        }

        return new int[] { arr[pq.peek()[0]], arr[pq.peek()[1]] };
    }
}
