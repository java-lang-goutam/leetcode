class Solution {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 1)
            return 1;

        int i = 1, result = 1;
        while (i < nums.length && nums[i - 1] == nums[i])
            i++;

        if (i == nums.length)
            return result;

        boolean up = nums[i] > nums[i - 1];

        for (; i < nums.length; i++) {
            if ((up && nums[i] > nums[i - 1]) || (!up && nums[i] < nums[i - 1])) {
                result++;
                up = !up;
            }
        }

        return result;
    }
}