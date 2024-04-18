class Solution {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int r = 0, rn = grid.length; r < rn; r++) {
            for (int c = 0, cn = grid[0].length; c < cn; c++) {
                if (grid[r][c] == 1) {
                    sum += getPerimiter(r, c, grid);
                }
            }
        }

        return sum;
    }

    private int getPerimiter(final int row, final int col, final int[][] grid) {
        int sum = 0;

        // top
        if (row == 0 || grid[row - 1][col] == 0) sum++;

        // bottom
        if (row == grid.length - 1 || grid[row + 1][col] == 0) sum++;

        //left
        if (col == 0 || grid[row][col - 1] == 0) sum++;

        // right
        if (col == grid[0].length - 1 || grid[row][col + 1] == 0) sum++;

        return sum;
    }
}
