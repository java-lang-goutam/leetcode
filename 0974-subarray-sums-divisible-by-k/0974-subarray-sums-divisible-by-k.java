/**
https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217980/Java-O(N)-with-HashMap-and-prefix-Sum
*/
class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        int subArrays = 0, sum = 0;
        final Map<Integer, Integer> prefixSum = new HashMap<>() {{ put(0, 0); }};
        for (int i = 0, n = nums.length; i < n; i++) {
            int rem = (sum += nums[i]) % k;
            if (rem < 0) rem += k;
            subArrays += prefixSum.compute(rem, (u, v) -> v == null ? 0 : 1 + v);
        }

        return subArrays;
    }
}
