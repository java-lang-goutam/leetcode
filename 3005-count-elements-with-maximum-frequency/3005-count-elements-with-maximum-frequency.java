class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int maxFrequency = 0, sum = 0;
        final int[] freq = new int[101];
        for (final int num : nums) {
            freq[num]++;
            final int currentFreq = freq[num];
            if (maxFrequency < currentFreq) {
                sum = currentFreq;
                maxFrequency = sum;
            } else if (maxFrequency == currentFreq) {
                sum += currentFreq; 
            }
            
            //System.out.println(Arrays.toString(freq));
        }
        
        return sum;
    }
}