class Solution {
    public int minPatches(int[] nums, int n) {
        int i=0, patches = 0;
        long currRange = 1L;
        
        while (currRange <= n) {
            if (i < nums.length && nums[i] <= currRange) {
                currRange += nums[i];
                i++;
            } else {
                patches++;
                currRange += currRange;
            }
        }
        
        return patches;
    }
}