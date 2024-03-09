class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        for (int ele : nums2) {
            if (exists(nums1, ele)) return ele;
        }
        
        return -1;
    }
    
    public boolean exists(final int[] nums, final int ele) {
        
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            final int mid = ((high + low) >> 1);
            final int middleEle = nums[mid];
            if (middleEle == ele) return true;
            if (middleEle < ele) low = mid + 1;
            else high = mid - 1;
        }
        
        return false;
    }
}