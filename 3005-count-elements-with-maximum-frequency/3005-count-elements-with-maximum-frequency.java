class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int maxFrequency = 0, sum = 0;
        final int[] freq = new int[101];
        for (final int num : nums) {
            freq[num]++;
            if (maxFrequency < freq[num]) {
                sum = freq[num];
                maxFrequency = sum;
            } else if (maxFrequency == freq[num]) {
                sum += freq[num]; 
            }
            
            //System.out.println(Arrays.toString(freq));
        }
        
        return sum;
    }
}