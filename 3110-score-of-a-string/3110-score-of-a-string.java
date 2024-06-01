class Solution {
    public int scoreOfString(String s) {
        
        int score = 0;
        for (int i=1, n = s.length(); i < n; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        
        return score;
    }
}