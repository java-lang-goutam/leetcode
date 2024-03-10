class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        final int[] count = new int[1001];
        //final int[] intersection = new int[1001];

        for (int num : nums1) {
            count[num] = 1;
        }
        
        final int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int length = 0;
        for (int num : nums2) {
            if (count[num]-- == 1) intersection[length++] = num;
        }

        final int[] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = intersection[i];
        }
        
        return result;
    }
}