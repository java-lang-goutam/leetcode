class Solution {

    public int trap(int[] height) {
        final int N = height.length;
        final int[] right = new int[N];

        int max = 0, waterTrapped = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (height[i] > max) max = height[i];
            right[i] = max;
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            if (height[i] > max) max = height[i];
            final int curr = Math.min(max, right[i]) - height[i];
            if (curr > 0) waterTrapped += curr;
        }

        return waterTrapped;
    }
}
