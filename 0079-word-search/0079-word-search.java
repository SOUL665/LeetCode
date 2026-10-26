class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();

        int[] boardFreq = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardFreq[board[i][j]]++;
            }
        }

        int[] wordFreq = new int[128];
        for (char c : w) {
            wordFreq[c]++;
            if (wordFreq[c] > boardFreq[c]) {
                return false;
            }
        }

        if (boardFreq[w[w.length - 1]] < boardFreq[w[0]]) {
            for (int i = 0, j = w.length - 1; i < j; i++, j--) {
                char temp = w[i];
                w[i] = w[j];
                w[j] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == w[0] && dfs(board, w, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] word, int r, int c, int idx) {
        if (idx == word.length) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word[idx]) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, word, r + 1, c, idx + 1)
                     || dfs(board, word, r - 1, c, idx + 1)
                     || dfs(board, word, r, c + 1, idx + 1)
                     || dfs(board, word, r, c - 1, idx + 1);

        board[r][c] = temp;
        return found;
    }
}