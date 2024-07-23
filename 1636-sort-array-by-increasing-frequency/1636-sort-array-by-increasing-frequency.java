class Solution {

    public int[] frequencySort(int[] nums) {
        final int[] freq = new int[201];
        for (int num : nums) freq[num + 100]++;

        final PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int diff = freq[a + 100] - freq[b + 100];
                if (diff != 0) return diff;
                return b - a;
            }
        );

        for (int num : nums) pq.offer(num);
        for (int i = 0; i < nums.length; i++) nums[i] = pq.poll();

        return nums;
    }
}
