class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean col[], rDiag[], lDiag[];
    char board[][];

    void backtrack(int row, int n, char board[][], List<List<String>> res) {
        if(row == n){
            List<String> l = new ArrayList<>();
            for(char[] ch: board){
                l.add(new String(ch));
            }
            res.add(l);
            return;
        }
        for(int i=0; i<n; i++){
            int d1 = row - i + n - 1;
            int d2 = row + i;

            if(col[i] || rDiag[d1] || lDiag[d2]) continue;

            board[row][i] = 'Q';
            col[i] = true;
            rDiag[d1] = true;
            lDiag[d2] = true;

            backtrack(row+1, n, board, res);

            board[row][i] = '.';
            col[i] = false;
            rDiag[d1] = false;
            lDiag[d2] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        col = new boolean[n];
        rDiag = new boolean[2*n-1];
        lDiag = new boolean[2*n-1];
        backtrack(0, n, board, res);
        return res;
    }
}