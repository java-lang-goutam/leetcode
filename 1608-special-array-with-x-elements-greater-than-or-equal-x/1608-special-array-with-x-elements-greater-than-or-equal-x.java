class Solution {
    public int specialArray(int[] nums) {
        
        final int[] freq = new int[1001];
        for (int num : nums) freq[num]++;
        
        int noOfValues = 0;
        for(int i=freq.length - 1; i>=0; i--) {
            if (freq[i] > 0) noOfValues += freq[i];
            if (i == noOfValues) return i;
        }
        
        return -1;
    }
}