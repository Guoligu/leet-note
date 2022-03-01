package test.exam.msbank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int red = 0;
        int yellow = 0;
        int blue = 0;
        if (input.contains("red")) {
            red++;
        }
        if (input.contains("yellow")) {
            yellow++;
        }
        if (input.contains("blue")) {
            blue++;
        }

        System.out.println(red + " " + yellow + " " + blue);
    }

    public static void testP1() {
        Main m = new Main();
        int ans = m.answerSheet("1100010000100001","ABCD");
        System.out.println(ans);
    }

    public int answerSheet (String s, String t) {
        // write code here
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int ans = 0;
        int n = t.length();

        for (int i = 0; i < n; i++) {
            int offset = t.charAt(i) - 'A';
            int pos = 4 * i;
            if (s.charAt(pos+offset) == '1') {
                int cnt = 0;
                for (int j = 0; j < 4; j++) {
                    if (s.charAt(pos+j) == '1') {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
