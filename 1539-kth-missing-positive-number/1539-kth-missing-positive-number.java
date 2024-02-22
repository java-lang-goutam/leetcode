class Solution {

    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length;

        // find the first element whose diff with actual is greater than k
        while (low < high) {
            final int mid = low + ((high - low) >> 1);
            final int diffElement = arr[mid] - (mid + 1);
            if (diffElement < k) low = mid + 1; else high = mid;
        }

        // how much the next greater element is more than k ?
        // we know the position res = arr[high] - (diff[high] - k + 1) = arr[high] - diff[high] + k - 1
        // diff[high] = arr[high] - (high + 1) =  arr[high] - high - 1
        // res = arr[high] - arr[high] + high + 1 + k - 1 = high + k

        return high + k;
    }
}
