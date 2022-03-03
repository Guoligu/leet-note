package test.exam.netease;

import java.util.*;

public class Main {

    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] a = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2}; //17
        char[] r = {'1','0','X','9','8','7','6','5','4','3','2'}; //11
        for (int k = 0; k < n; k ++) {
            String line = sc.nextLine();
            int sum = 0;
            for (int i = 0; i < 14; i++) {
                char ch = line.charAt(i);
                int num = ch - '0';
                sum += num * a[i];
            }
            ans = 0;
            backtrack(line, 14, sum, a, r);
            System.out.println(ans);
        }
    }

    public static void backtrack(String line, int deep, int sum, int[] a, char[] r) {
        if (deep == 17) {
            char last = r[sum % 11];
            if (last == line.charAt(17)) {
                ans++;
            }
            return;
        }

        char ch = line.charAt(deep);
        if (ch != '*') {

            int num = (ch - '0') * a[deep];
            sum += num;
            backtrack(line, deep+1, sum, a, r);
            sum -= num;
        } else {

            for (int j = 0; j <= 9; j++) {
                int num = j * a[deep];
                sum += num;
                backtrack(line, deep+1, sum, a, r);
                sum -= num;
            }
        }
    }
}
