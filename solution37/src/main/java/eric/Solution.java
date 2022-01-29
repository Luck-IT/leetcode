package solution37;

public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        help(board, 0);
    }

    private boolean help(char[][] board, int i) {
        int row = i / 9;
        int col = i % 9;
        if (row >= 9 || col >= 9) {
            return false;
        }
        if (board[row][col] == '.') {
            for (int piov = 1; piov <= 9; piov++) {
                board[row][col] = (char) ('0' + piov);
                if (check(board, row, col)) {
                    if(row == 8 && col == 8){
                        return true;
                    }
                    boolean flag = help(board, i + 1);
                    if (flag) {
                        return flag;
                    }
                }
                board[row][col] = '.';
            }
        } else {
            if(row == 8 && col == 8){
                return true;
            }
            return help(board, i + 1);
        }
        return false;
    }

    //检查是否由重复，true 没有重复，false 有重复
    private boolean check(char[][] board, int row, int col) {
        // row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == board[row][col] && col != i) {
                return false;
            }
        }
        // col check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == board[row][col] && row != i) {
                return false;
            }
        }

        // 3*3 check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == board[row][col] && (j!=col && i != row)) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        Solution s = new Solution();
        s.solveSudoku(board);
        System.out.println();
    }
}