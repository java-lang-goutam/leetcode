class Solution {
    public int matrixScore(int[][] grid) {
        
        final int m = grid.length;
        final int n = grid[0].length;
        
        // iterate every row and flip bit if first bit is not set
        for (int r=0; r<m; r++) {
            if (grid[r][0] == 0) {
                for (int c=0; c<n; c++) {
                    grid[r][c] = 1 - grid[r][c];
                }
            }
        }
        
        // iterate every col and count no of zeros / ones
        for (int c=0; c<n;c++) {
            int countZero = 0;
            for (int r=0; r<m; r++) {
                if (grid[r][c] == 0) countZero++;
            }
            
            // flip if there are more zeros in cols
            if (countZero > m - countZero) {
                for (int r=0; r<m; r++) {
                    grid[r][c] = 1 - grid[r][c];
                }
            }
        }
        
        // We have optimized metrix
        // count the values
        // every set bit is 2^m + 2^m-1 ..
        int score = 0;
        for (int r=0; r<m; r++) {
            for (int c = 0; c < n; c++) {
                
                // since we are moving left to right we hvae to use n - j -1
                score += grid[r][c] << (n - c - 1);
            }
        }
        
        return score;
    }
}