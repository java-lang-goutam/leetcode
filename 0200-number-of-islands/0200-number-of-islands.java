class Solution {
    public int numIslands(char[][] grid) {
        
        final char land = '1';
        int islandCount = 0;
        for (int r=0, rn = grid.length; r < rn; r++) {
            for (int c=0, cn = grid[0].length; c < cn; c++) {
                if (grid[r][c] == land) {
                    bfs(r, c, grid);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    private void bfs(final int row, final int col, final char[][] grid) {
        
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        final int maxRowIndex = grid.length - 1;
        final int maxColIndex = grid[0].length - 1;
        final char land = '1';
        final char water = '0';
        
        grid[row][col] = water;
        
        while (!queue.isEmpty()) {
            final int[] rc = queue.poll();
            final int r = rc[0];
            final int c = rc[1];
            final int nextRow = r + 1, prevRow = r - 1;
            final int nextCol = c + 1, prevCol = c - 1;
            
            if (r > 0 && grid[prevRow][c] == land) {
                grid[prevRow][c] = water;
                queue.offer(new int[]{prevRow, c});
            } 
            if (r < maxRowIndex && grid[nextRow][c] == land) {
                grid[nextRow][c] = water;
                queue.offer(new int[]{nextRow, c});
            }
            if (c > 0 && grid[r][prevCol] == land) {
                grid[r][prevCol] = water;
                queue.offer(new int[]{r, prevCol});
            } 
            if (c < maxColIndex && grid[r][nextCol] == land) {
                grid[r][nextCol] = water;
                queue.offer(new int[]{r, nextCol});
            } 
        }
    }
}