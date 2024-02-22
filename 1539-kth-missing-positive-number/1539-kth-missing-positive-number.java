class Solution {

    public int findKthPositive(int[] arr, int k) {
        int prev = 0;
        for (final int ele : arr) {
            final int diff = ele - prev - 1;
            k -= diff;
            if (k > 0) {
                prev = ele;
            } else {
                return k + ele - 1;
            }
        }

        return prev + k;
    }
}
