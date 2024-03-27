class NumArray {

    private final int[] prefixSum;
    
    public NumArray(int[] nums) {
        final int n = nums.length;
        prefixSum = new int[n];
        
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        
        //System.out.println(Arrays.toString(prefixSum));
    }
    
    public int sumRange(int left, int right) {
        
        return (left == 0) ? prefixSum[right] : prefixSum[right] - prefixSum[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */