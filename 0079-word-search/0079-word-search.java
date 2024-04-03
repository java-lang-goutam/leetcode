class Solution {

    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        final char firstChar = word.charAt(0);
        final boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    if (check(board, word, 0, visited, i, j, m, n)) return true;
                }
            }
        }

        return false;
    }

    private boolean check(final char[][] board, final String word, final int wordIndex, final boolean[][] visited, final int x, final int y, final int m, final int n) {
        if (wordIndex == word.length() - 1) return true;
        visited[x][y] = true;

        final int[][] move = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        for (int i = 0; i < 4; i++) {
            int newX = x + move[i][0];
            if (newX < 0 || newX == m) continue;

            int newY = y + move[i][1];
            if (newY < 0 || newY == n) continue;

            if (!visited[newX][newY] && board[newX][newY] == word.charAt(wordIndex + 1)) {
                if (check(board, word, wordIndex + 1, visited, newX, newY, m, n)) return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}
