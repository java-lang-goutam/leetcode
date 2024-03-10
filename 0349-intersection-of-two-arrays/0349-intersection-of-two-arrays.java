class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        final int[] count = new int[1001];
        final int[] intersection = new int[nums1.length];

        for (final int num : nums1) count[num] = 1;

        int length = 0;
        for (final int num : nums2) {
            if (count[num]-- == 1) intersection[length++] = num;
        }

        final int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = intersection[i];
        }

        return result;
    }
}
