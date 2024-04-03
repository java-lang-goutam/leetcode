class Solution {

    public boolean exist(char[][] board, String word) {
        final int totalRows = board.length;
        final int totalCols = board[0].length;

        final boolean[][] included = new boolean[totalRows][totalCols];

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, included, board, word)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int index, boolean[][] included, char[][] board, String word) {
        if (index == word.length() - 1) return true;

        included[i][j] = true;
        final char nextChar = word.charAt(index + 1);

        // up check
        if (i > 0 && board[i - 1][j] == nextChar && !included[i - 1][j] && dfs(i - 1, j, index + 1, included, board, word)) {
            return true;
        }

        // down check
        if (i < board.length - 1 && board[i + 1][j] == nextChar && !included[i + 1][j] && dfs(i + 1, j, index + 1, included, board, word)) {
            return true;
        }

        // left check
        if (j > 0 && board[i][j - 1] == nextChar && !included[i][j - 1] && dfs(i, j - 1, index + 1, included, board, word)) {
            return true;
        }

        // right check
        if (j < board[0].length - 1 && board[i][j + 1] == nextChar && !included[i][j + 1] && dfs(i, j + 1, index + 1, included, board, word)) {
            return true;
        }
        
        included[i][j] = false;
        
        return false;
    }
}
