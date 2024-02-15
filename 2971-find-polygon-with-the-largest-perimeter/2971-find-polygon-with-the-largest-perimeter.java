class Solution {
    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);
        final int length = nums.length;
        int maxSoFar = Math.max(nums[0], nums[1]);
        long sumSoFar = nums[0] + nums[1];
        long maxPossibleSum = -1L;

        for (int i = 2; i < length; i++) {
            if (nums[i] < sumSoFar) {
                maxPossibleSum = sumSoFar + nums[i];
            }
            sumSoFar += nums[i];
        }

        return maxPossibleSum;
    }
}