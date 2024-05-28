class Solution {
    
    // [1, 1, 1, 3]
    
    public int equalSubstring(String s, String t, int maxCost) {
        
        final int size = s.length();
        final int[] arr = new int[size];
        
        for (int i=0; i < size; i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
    
        
        int maxLen = 0, cost = 0, start = 0;
        
        for (int i=0; i<size; i++) {
            
            // add currIndex
            cost += arr[i];
            
            // remove index if cost exceeded
            while (cost > maxCost) {
                cost -= arr[start++];
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
    
}