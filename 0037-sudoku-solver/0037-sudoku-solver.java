/**
https://www.youtube.com/watch?v=uyetDh-DyDg
*/

class Solution {

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean isValid(char[][] board, char val, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) return false;
            if (board[i][col] == val) return false;
        }

        final int gridRowStart = (row / 3) * 3;
        final int gridColStart = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + gridRowStart][j + gridColStart] == val) return false;
            }
        }

        return true;
    }

    public boolean solve(char[][] board, int r, int c) {
        //System.out.println("row : "+ r + ", col : " + c);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char val = '1'; val <= '9'; val++) {
                        if (isValid(board, val, row, col)) {
                            board[row][col] = val;
                            if (solve(board, row, col)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
