class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = board[i][j] - 'a';
                if (root.children[idx] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        int idx = ch - 'a';
        TrieNode curr = parent.children[idx];

        if (curr == null) {
            return;
        }

        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }

        board[r][c] = '#';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#') {
                int nextIdx = board[nr][nc] - 'a';
                if (curr.children[nextIdx] != null) {
                    dfs(board, nr, nc, curr, result);
                }
            }
        }

        board[r][c] = ch;

        boolean hasChild = false;
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                hasChild = true;
                break;
            }
        }
        if (!hasChild) {
            parent.children[idx] = null;
        }
    }
}