class Solution {

    /**
        Strategy is to mark the occurance/index as negative so that in next iteration we will know which number is missing    
    */
    public int firstMissingPositive(int[] nums) {
        final int size = nums.length;
        final int maxVal = 1_000_000;

        // remove all negatives and zeros
        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0) nums[i] = maxVal;
        }

        // mark all valid index as negative
        for (int i = 0; i < size; i++) {
            final int index = Math.abs(nums[i]) - 1;
            if (index >= size) continue;
            if (nums[index] > 0) nums[index] *= -1;
        }

        // find first positive number
        int i = 0;
        while (i < size) {
            if (nums[i] >= 0) break;
            i++;
        }

        return i + 1;
    }
}
