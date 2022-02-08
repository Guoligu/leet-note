package leet.soluiton;

import java.util.*;

/**
 * @desc: n皇后
 * @tag: 回溯
 */
public class P51 {
    public static void main(String[] args) {
        P51 p = new P51();
        List<List<String>> ans = p.solveNQueens(4);

        for (List<String> matrix : ans) {
            System.out.println(matrix);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        return s1(n);
    }

    /**
     * 方法一：使用数组记录皇后不能停的位置
     */
    public List<List<String>> s1(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        boolean[] vc = new boolean[n];       // visited columns
        boolean[] vd1 = new boolean[2*n+1];  // visited diagonal 1
        boolean[] vd2 = new boolean[2*n+1];  // visited diagonal 2

        // 把n行皇后的字符串先构建出来
        String[] queens = new String[n];
        char[] temp = new char[n];
        Arrays.fill(temp, '.');
        for (int i = 0; i < n; i++) {
            temp[i] = 'Q';
            queens[i] = new String(temp);
            temp[i] = '.';
        }

        backtrack(queens, ans, board, n, 0, vc, vd1, vd2);

        return ans;
    }

    public void backtrack(String[] line, List<List<String>> ans, List<String> matrix, int n, int j, boolean[] vc, boolean[] vd1, boolean[] vd2) {
        // j 为纵坐标
        if (j == n) {
            ans.add(new ArrayList<>(matrix));
        }
        // i 为横坐标
        for (int i = 0; i < n; i++) {
            if (!vc[i] && !vd1[n + j - i] && !vd2[i + j]) {

                vc[i]      = true;
                vd1[n+j-i] = true;
                vd2[i+j]   = true;
                matrix.add(line[i]);

                backtrack(line, ans, matrix, n, j+1, vc, vd1, vd2);

                vc[i]      = false;
                vd1[n+j-i] = false;
                vd2[i+j]   = false;
                matrix.remove(j);
            }
        }
    }
}
