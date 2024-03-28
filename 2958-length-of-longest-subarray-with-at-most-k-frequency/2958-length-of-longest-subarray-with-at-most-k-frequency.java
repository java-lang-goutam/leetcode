class Solution {

    public int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> numFreq = new HashMap<>();
        int maxSize = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            final int currNum = nums[right];
            final int freq = numFreq.compute(currNum, (key, val) -> val == null ? 1 : val + 1);

            while (freq > k) {
                int leftVal = nums[left++];
                numFreq.compute(leftVal, (key, val) -> val - 1);
                if (leftVal == currNum) break;
            }

            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }
}
