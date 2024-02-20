class Solution {
    public int missingNumber(int[] nums) {

        final int length = nums.length;
        boolean lengthNum = false;

        for (int i = 0; i < length; i++) {
            final int num = Math.abs(nums[i]);
            if (num < length) {
                nums[num] = -nums[num];
            } else {
                lengthNum = true;
            }
        }

        if (!lengthNum)
            return length;

        int result = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
               return i;
            } else if (nums[i] == 0) {
                result = i;
            }
        }

        return result;
    }
}