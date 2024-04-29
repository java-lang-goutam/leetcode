class Solution {
    
    private int countDiffBits(final String s1, final String s2) {
        if (s1.length() < s2.length()) return countDiffBits(s2, s1);
        
        int count = 0, i = 0;
        for (int n = s1.length() - s2.length(); i < n; i++) {
            //System.out.println("first : " + s1.charAt(i));
            if (s1.charAt(i) == '1') count++;
        }
        
        int i2=0;
        while (i < s1.length()) {
            if (s1.charAt(i++) != s2.charAt(i2++)) count++;
        }
        
        return count;
    }
    
    public int minOperations(int[] nums, int k) {
        
        int xor = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            xor ^= nums[i];
        }
        
        final String binaryXor = Integer.toBinaryString(xor);
        final String binaryK = Integer.toBinaryString(k);
        
        return countDiffBits(binaryXor, binaryK);
    }
}