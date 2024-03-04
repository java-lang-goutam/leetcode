public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        
        int i=0, j = tokens.length - 1, score = 0, maxScore = 0;
        while (i <= j) {
            final int currentToken = tokens[i];
            if (currentToken <= power) {
                power -= currentToken;
                i++;
                if (++score > maxScore) maxScore = score;
            } else if (score > 0) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        
        return maxScore;
    }
}