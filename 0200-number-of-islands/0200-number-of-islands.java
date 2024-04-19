class Solution {

    public int numIslands(char[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int noOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    searchIsland(grid, i, j);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }

    private void searchIsland(final char[][] grid, final int r, final int c) {
        
        grid[r][c] = 0;

        if (c + 1 < grid[0].length && grid[r][c + 1] == '1') searchIsland(grid, r, c + 1);
        if (r + 1 < grid.length && grid[r + 1][c] == '1') searchIsland(grid, r + 1, c);
        if (c > 0 && grid[r][c - 1] == '1') searchIsland(grid, r, c - 1);
        if (r > 0 && grid[r - 1][c] == '1') searchIsland(grid, r - 1, c);
    }
}
