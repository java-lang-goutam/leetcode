class Solution {
    public int minimumLength(String s) {
        
        int i=0, j=s.length() - 1;
        
        while (i < j) {
            char firstChar = s.charAt(i);
            char lastChar = s.charAt(j);
            
            if (firstChar != lastChar) return j-i+1;
            
            while (firstChar == s.charAt(++i) && i < j);
            while (lastChar == s.charAt(--j) && i < j);
        }
        
        return j-i+1;
    }
}