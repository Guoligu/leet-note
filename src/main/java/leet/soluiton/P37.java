package leet.soluiton;

import utils.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 数独
 * @tag: 回溯
 */
public class P37 {
    public static void main(String[] args) {
        P37 p = new P37();
        char[][] board = Tool.createTwoDimArr("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        p.solveSudoku(board);
        Tool.showTwoDimArr(board);
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        final int boardSize = board.length;

        // 记录第i 行/列/块 中是否有数字digit
        boolean[][] row = new boolean[boardSize][boardSize+1];
        boolean[][] column = new boolean[boardSize][boardSize+1];
        boolean[][][] block = new boolean[boardSize/3][boardSize/3][boardSize+1];

        // 记录数独中空白格子的位置
        List<int[]> pos = new ArrayList<>();

        // init
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '.') {
                    pos.add(new int[] {i, j});
                } else {
                    int digit = board[i][j] - '0';
                    // 数组下标从0开始
                    row[i][digit]          = true;
                    column[j][digit]       = true;
                    block[i/3][j/3][digit] = true;
                }
            }
        }

        backtrack(board, 0, pos, row, column, block);
    }

    public boolean backtrack(char[][] board, int k, List<int[]> pos, boolean[][] row, boolean[][] column, boolean[][][] block) {
        if (k == pos.size()) {
            return true;
        }

        int i = pos.get(k)[0];
        int j = pos.get(k)[1];
        for (int digit = 1; digit <= 9; digit++) {

            if (row[i][digit] || column[j][digit] || block[i/3][j/3][digit]) {
                continue;
            }

            row[i][digit]          = true;
            column[j][digit]       = true;
            block[i/3][j/3][digit] = true;
            board[i][j] = (char) (digit + '0');

            boolean finished = backtrack(board, k+1, pos, row, column, block);
            // 找到答案逐层跳出递归
            if (finished) {
                return true;
            }

            row[i][digit]          = false;
            column[j][digit]       = false;
            block[i/3][j/3][digit] = false;
            board[i][j] = '.';
        }

        return false;
    }
}
