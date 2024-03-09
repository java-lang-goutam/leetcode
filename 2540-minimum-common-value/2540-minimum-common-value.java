class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        final int[] smaller, bigger;
        
        if (nums1.length < nums2.length) {
            smaller = nums1;
            bigger = nums2;
        } else {
            smaller = nums2;
            bigger = nums1;
        }
        
        for (int ele : bigger) {
            if (exists(smaller, ele)) return ele;
        }
        
        return -1;
    }
    
    public boolean exists(final int[] nums, final int ele) {
        
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            final int mid = low + ((high - low) >> 1);
            final int middleEle = nums[mid];
            if (middleEle == ele) return true;
            if (middleEle < ele) low = mid + 1;
            else high = mid - 1;
        }
        
        return false;
    }
}