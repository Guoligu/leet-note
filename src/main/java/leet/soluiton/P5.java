package leet.soluiton;

/**
 * @tag: dp
 * @desc: 最长回文子串
 */
public class P5 {
    public static void main(String[] args) {
        P5 p = new P5();
        String ans = p.longestPalindrome("aaaaababa");
        System.out.println(ans);
    }

    public String longestPalindrome(String s) {
        // 判空
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int maxLen = 0;
        int[] maxLenPos = new int[] {0, 0};
        int len = s.length();
        char[] chars = s.toCharArray();

        // 记录[i, j]区间内的子串是否为回文
        boolean[][] dp = new boolean[len][len];

        // 对每个位置作为起始的不同长度的子串进行遍历，
        // 必须在循环外层遍历子串长度，内层遍历子串起始位置
        for (int subLen = 1; subLen <= len; subLen++) {
            for (int i = 0; i < len; i++) {
                int j = i + subLen - 1;
                if (j >= len) {
                    break;
                }
                if (chars[j] == chars[i]) {
                    // 子串长度小于3的可以直接认定为回文，例：a,aa,aba
                    if (subLen < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && subLen > maxLen) {
                    maxLen = subLen;
                    maxLenPos[0] = i;
                    maxLenPos[1] = j;
                }
            }
        }

        return s.substring(maxLenPos[0], maxLenPos[1]+1);
    }
}
