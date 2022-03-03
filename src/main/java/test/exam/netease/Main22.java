package test.exam.netease;

import java.util.*;

public class Main22 {

    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {


            int n = sc.nextInt();
            int[][] adj = new int[n][n];
            List<Integer> root = new ArrayList<>();
            int[] d = new int[n];

            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
                int K = sc.nextInt();
                if (K == 0) {
                    root.add(i);
                }
                for (int k = 0; k < K; k++) {
                    int j = sc.nextInt() - 1;
                    adj[j][i] = 1;
                }
            }


            ans = 0;
            for (Integer node : root) {
                dfs(node, adj, d, 0);
            }
            System.out.println(ans);


        }
    }

    public static void dfs(int node, int[][] adj, int[] d, int max) {
        int n = adj.length;

        for (int i = 0; i < n; i++) {
            if (adj[node][i] == 1) {
                dfs(i, adj, d, max+d[node]);
            }
        }

        ans = Math.max(ans, max + d[node]);
    }


}
