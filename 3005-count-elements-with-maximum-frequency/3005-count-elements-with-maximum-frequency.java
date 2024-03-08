class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int maxFrequency = 0;
        final int[] freq = new int[101];
        for (final int num : nums) {
            freq[num]++;
            maxFrequency = Math.max(maxFrequency, freq[num]);
        }
        
        int sum = 0;
        for (int f : freq) {
            if (f == maxFrequency) sum += f;
        }
        
        return sum;
    }
}