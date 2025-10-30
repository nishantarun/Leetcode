class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        NQueens(board, 0, n);
        return res;
    }

    public void NQueens(List<String> board, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                String curr = board.get(row);
                char[] charr = curr.toCharArray();
                charr[col] = 'Q';
                board.set(row, new String(charr));

                NQueens(board, row + 1, n);

                charr[col] = '.';
                board.set(row, new String(charr));
            }
        }
    }

    public boolean isSafe(List<String> board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}