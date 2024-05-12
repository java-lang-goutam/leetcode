class Solution {

    public int[][] largestLocal(int[][] grid) {
        final int n = grid.length;
        final int[][] res = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                
                int maxVal = 0;
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        maxVal = Math.max(maxVal, grid[i + r][j + c]);
                    }
                }

                res[i][j] = maxVal;
            }
        }

        return res;
    }
}
