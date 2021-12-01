package leet.soluiton;

import java.util.*;

/**
 * @desc: n皇后
 * @tag: 回溯
 */
public class P51 {
    public static void main(String[] args) {
        P51 p = new P51();
        List<List<String>> ans = p.solveNQueens(1);

        for (List<String> matrix : ans) {
            System.out.println(matrix);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        return s2(n);
    }

    /**
     * 方法一：暴力，时间复杂度O(n * n!)
     */
    public List<List<String>> s1(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> matrix = new ArrayList<>();
        backtrack(0, n, ans, matrix);

        return ans;
    }

    public void backtrack(int row, int n, List<List<String>> ans, List<String> matrix) {
        if (row == n) {
            ans.add(new ArrayList<>(matrix));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isValid(row, column, matrix, n)) {
                matrix.add(buildLine(column, n));
                backtrack(row+1, n, ans, matrix);
                matrix.remove(row);
            }
        }
    }

    public boolean isValid(int row, int column, List<String> matrix, int n) {
        for (String line : matrix) {
            if (line.charAt(column) == 'Q') {
                return false;
            }
        }

        for (int k = 1; k <= row; k++) {
            if (column < k) {
                break;
            }
            if (matrix.get(row-k).charAt(column-k) == 'Q') {
                return false;
            }
        }

        for (int k = 1; k <= row; k++) {
            if (column + k >= n) {
                break;
            }
            if (matrix.get(row-k).charAt(column+k) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public String buildLine(int i, int n) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            if (k == i) {
                sb.append("Q");
            }else {
                sb.append(".");
            }
        }
        return new String(sb);
    }

    /**
     * 将非法位置判断时间由O(n)优化为O(1)
     */
    public List<List<String>> s2(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n]; // 0-. 1-Q
        for (char[] line : board) {
            Arrays.fill(line, '.');
        }
        Set<Integer> flagUp = new HashSet<>();
        Set<Integer> flagLeft = new HashSet<>();
        Set<Integer> flagRight = new HashSet<>();
        backtrack2(0, n, ans, board, flagUp, flagLeft, flagRight);

        return ans;
    }

    public void backtrack2(int row, int n, List<List<String>> ans,char[][] board, Set<Integer> flagUp,Set<Integer> flagLeft,Set<Integer> flagRight) {
        if (row == n) {
            ans.add(buildBoard(board));
            return;
        }

        for (int column = 0; column < n; column++) {
            if (flagUp.contains(column) || flagLeft.contains(row-column) || flagRight.contains(row+column)) {
                continue;
            }

            flagUp.add(column);
            flagLeft.add(row-column);
            flagRight.add(row+column);
            board[row][column] = 'Q';

            backtrack2(row+1, n, ans, board, flagUp, flagLeft, flagRight);

            flagUp.remove(column);
            flagLeft.remove(row-column);
            flagRight.remove(row+column);
            board[row][column] = '.';
        }
    }

    public List<String> buildBoard(char[][] a) {
        List<String> board = new ArrayList<>();
        for (char[] line : a) {
            board.add(new String(line));
        }

        return board;
    }
}
