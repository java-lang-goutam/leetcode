class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int x = nums1.length;
        final int y = nums2.length;

        if (x > y) return findMedianSortedArrays(nums2, nums1);

        final int totalLength = x + y;
        final int paritionSize = ((totalLength + 1) >> 1);
        final int INF = Integer.MAX_VALUE;
        final int NEG_INF = Integer.MIN_VALUE;

        //System.out.println("paritionSize : " + paritionSize);

        int low = 0, high = x;

        while (low <= high) {
            final int partitionX = ((low + high) >> 1);
            final int partitionY = paritionSize - partitionX;

            final int maxLeftX = partitionX == 0 ? NEG_INF : nums1[partitionX - 1];
            final int minRightX = partitionX == x ? INF : nums1[partitionX];

            final int maxLeftY = partitionY == 0 ? NEG_INF : nums2[partitionY - 1];
            final int minRightY = partitionY == y ? INF : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // System.out.println("maxLeftX : " + maxLeftX);
                // System.out.println("minRightX : " + minRightX);
                // System.out.println("maxLeftY : " + maxLeftY);
                // System.out.println("minRightY : " + minRightY);

                if ((totalLength & 1) == 1) {
                    return (double) Math.max(maxLeftX, maxLeftY);
                } else {
                    // System.out.println("odd : " + false);
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}
