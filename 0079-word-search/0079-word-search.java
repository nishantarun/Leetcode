class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int row, int col, int idx, int[][] visited) {
        if (idx == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] == 1
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = 1;

        boolean found = helper(board, word, row, col + 1, idx + 1, visited) ||
                helper(board, word, row + 1, col, idx + 1, visited) ||
                helper(board, word, row, col - 1, idx + 1, visited) ||
                helper(board, word, row - 1, col, idx + 1, visited);

        visited[row][col] = 0;
        return found;

    }
}