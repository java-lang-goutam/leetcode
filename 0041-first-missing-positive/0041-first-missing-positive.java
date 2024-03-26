class Solution {

    public int firstMissingPositive(int[] nums) {
        final int size = nums.length;
        final int maxVal = 1_000_000;

        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0) nums[i] = maxVal;
        }

        for (int i = 0; i < size; i++) {
            // System.out.println(Arrays.toString(nums));
            final int index = Math.abs(nums[i]);
            if (index > size) continue;
            if (nums[index-1] > 0) nums[index - 1] *= -1;
        }

        //System.out.println(Arrays.toString(nums));

        int i = 0;
        for (; i < size; i++) {
            if (nums[i] >= 0) return i + 1;
        }

        return i + 1;
    }
}
