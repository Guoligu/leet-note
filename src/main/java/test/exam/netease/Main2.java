package test.exam.netease;

import java.util.*;

public class Main2 {

    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {


            int n = sc.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            List<Integer> root = new ArrayList<>();
            int[] d = new int[n];

            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
                int K = sc.nextInt();
                if (K == 0) {
                    root.add(i);
                } else {
                    for (int k = 0; k < K; k++) {
                        int j = sc.nextInt() - 1;
                        adj.get(j).add(i);
                    }
                }

            }


            ans = 0;
            for (Integer node : root) {
                dfs(node, adj, d, 0);
            }
            System.out.println(ans);


        }
    }

    public static void dfs(int node, List<List<Integer>> adj, int[] d, int max) {
        List<Integer> list = adj.get(node);

        for (Integer next : list) {
            dfs(next, adj, d, max+d[node]);
        }


        ans = Math.max(ans, max + d[node]);
    }


}
