class Solution {
    public int longestNiceSubarray(int[] nums) {

        int j = 0, orSoFar = 0, result = 0;
        for (int i = 0, length = nums.length; i < length; i++) {
            while ((orSoFar & nums[i]) != 0) {
                orSoFar ^= nums[j++];
            }
            orSoFar |= nums[i];
            result = Math.max(result, i - j + 1);
        }

        return result;
    }
}