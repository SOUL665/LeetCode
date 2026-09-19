class Solution {
    public int numRookCaptures(char[][] board) {
        int rRow = -1;
        int rCol = -1;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] == 'R') {
                    rRow = r;
                    rCol = c;
                    break;
                }
            }
            if (rRow != -1) {
                break;
            }
        }

        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int r = rRow + dir[0];
            int c = rCol + dir[1];

            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == 'B') {
                    break;
                }
                if (board[r][c] == 'p') {
                    count++;
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }

        return count;
    }
}