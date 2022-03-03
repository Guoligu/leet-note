package test.exam.netease;

import utils.Tool;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {


            int n = sc.nextInt();
            int m1= sc.nextInt();
            int m2= sc.nextInt();
            int[][] adj = new int[n][n];

            for (int i = 0; i < m1; i++) {
                adj[sc.nextInt()-1][sc.nextInt()-1] = 1;
            }
            for (int i = 0; i < m2; i++) {
                adj[sc.nextInt()-1][sc.nextInt()-1] = 2;
            }

            Tool.showTwoDimArrWithIdx(adj);

//            int[][] dp = new int[n][2];
//            for (int i = 1; i < n; i++) {
//                for (int j = 0; j < m1; j++) {
//
//
//                }
//            }


            System.out.println(1);
        }

    }
}
