class Solution {

    public int numSubarraysWithSum(final int[] nums, final int goal) {
        int currentSum = 0, total = 0;
        final Map<Integer, Integer> sumOccurance = new HashMap<>();

        for (final int num : nums) {
            currentSum += num;
            if (currentSum == goal) total++;
            final int prefixSum = currentSum - goal;
            final Integer count = sumOccurance.get(currentSum - goal);
            if (count != null) {
                total += count;
            }

            sumOccurance.compute(currentSum, (k, v) -> v == null ? 1 : 1 + v);
        }

        return total;
    }
}
