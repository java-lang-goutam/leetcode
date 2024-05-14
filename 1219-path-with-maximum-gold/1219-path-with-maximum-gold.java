class Solution {

    public int getMaximumGold(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final boolean[][] visited = new boolean[m][n];
        int maxSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxSum = Math.max(maxSum, getMaximumGold(grid, visited, i, j));
                }
            }
        }

        return maxSum;
    }

    private int getMaximumGold(int[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        //System.out.println("i = " + i + ", j = " + j);

        int sum = 0;

        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] > 0) {
            sum = Math.max(sum, getMaximumGold(grid, visited, i - 1, j));
        }

        if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] > 0) {
            sum = Math.max(sum, getMaximumGold(grid, visited, i + 1, j));
        }

        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] > 0) {
            sum = Math.max(sum, getMaximumGold(grid, visited, i, j - 1));
        }

        if (j < grid[0].length - 1 && !visited[i][j + 1] && grid[i][j + 1] > 0) {
            sum = Math.max(sum, getMaximumGold(grid, visited, i, j + 1));
        }

        visited[i][j] = false;
        return sum + grid[i][j];
    }
}
