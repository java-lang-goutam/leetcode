class Solution {

    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        final char firstChar = word.charAt(0);
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar && check(board, word, 0, visited, i, j, m, n)) return true;
            }
        }

        return false;
    }

    private boolean check(final char[][] board, final String word, final int wordIndex, final boolean[][] visited, final int x, final int y, final int m, final int n) {
        if (wordIndex == word.length() - 1) return true;
        visited[x][y] = true;

        // up
        if (x > 0) {
            int newX = x - 1;
            if (board[newX][y] == word.charAt(wordIndex + 1) && !visited[newX][y] && check(board, word, wordIndex + 1, visited, newX, y, m, n)) return true;
        }

        // down
        if (x < m - 1) {
            int newX = x + 1;
            if (board[newX][y] == word.charAt(wordIndex + 1) && !visited[newX][y] && check(board, word, wordIndex + 1, visited, newX, y, m, n)) return true;
        }

        // left
        if (y > 0) {
            int newY = y - 1;
            if (board[x][newY] == word.charAt(wordIndex + 1) && !visited[x][newY] && check(board, word, wordIndex + 1, visited, x, newY, m, n)) return true;
        }

        // right
        if (y < n - 1) {
            int newY = y + 1;
            if (board[x][newY] == word.charAt(wordIndex + 1) && !visited[x][newY] && check(board, word, wordIndex + 1, visited, x, newY, m, n)) return true;
        }

        visited[x][y] = false;
        return false;
    }
}
