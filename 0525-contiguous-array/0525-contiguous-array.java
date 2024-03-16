class Solution {

    public int findMaxLength(int[] nums) {
        final Map<Integer, Integer> countIndex = new HashMap<>();
        int maxLen = 0, count = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            count += (nums[i] == 1 ? 1 : -1);
            if (count == 0) {
                maxLen = i + 1;
            }

            Integer index = countIndex.get(count);
            if (index != null) {
                maxLen = Math.max(maxLen, i - index);
            } else {
                countIndex.put(count, i);
            }
        }

        return maxLen;
    }
}
