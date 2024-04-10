class Solution {

    class Result {
        private int k;
        private String solution;
    }

    public String getPermutation(int n, int k) {
        final Result result = new Result();
        result.k = k;

        final char[] nums = new char[n];
        findPermutation(nums, 0, result);
        return result.solution;
    }

    private boolean isValid(char[] nums, char val) {
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] == val) return false;
        }
        return true;
    }

    private boolean findPermutation(final char[] nums, final int index, final Result result) {
        if (index == nums.length) {
            result.k--;
            if (result.k == 0) {
                result.solution = new String(nums);
                return true;
            } else {
                return false;
            }
        }

        for (char i = '1', n = (char) (nums.length + '0'); i <= n; i++) {
            if (isValid(nums, i)) {
                nums[index] = i;
                if (findPermutation(nums, index + 1, result)) return true;
                nums[index] = '\0';
            }
        }

        return false;
    }
}
