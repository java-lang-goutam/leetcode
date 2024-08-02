class Solution {

    private void merge(final int[] nums, final int start, final int mid, final int end) {
        int i = start;
        int j = mid + 1;
        final int[] tempArr = new int[end - start + 1];
        int t = 0;

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tempArr[t++] = nums[i++];
            } else {
                tempArr[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            tempArr[t++] = nums[i++];
        }

        while (j <= end) {
            tempArr[t++] = nums[j++];
        }

        t=0;
        while(t + start <= end) {
            nums[t + start] = tempArr[t++];
        }
    }

    private void sort(final int[] nums, final int start, final int end) {
        if (start < end) {
            final int mid = start + ((end - start)>>1);
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length -1);
        return nums;
    }
}