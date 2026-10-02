class Solution {
    private static final int[][] DIRS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        dfs(board, r, c);
        return board;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }

        int mines = countAdjacentMines(board, r, c);

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
        } else {
            board[r][c] = 'B';
            for (int[] dir : DIRS) {
                dfs(board, r + dir[0], c + dir[1]);
            }
        }
    }

    private int countAdjacentMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}