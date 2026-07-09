class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        backtrack(result, board, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        int n = board.length;
        if (row == n) {
            List<String> current = new ArrayList<>();
            for (char[] r : board) {
                current.add(new String(r));
            }
            result.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;
            int id2 = row + col;
            
            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            
            board[row][col] = 'Q';
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            
            backtrack(result, board, row + 1, cols, d1, d2);
            
            board[row][col] = '.';
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}