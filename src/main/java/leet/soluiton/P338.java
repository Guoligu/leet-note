package leet.soluiton;

/**
 * @desc: 比特位计数
 * @tag: dp
 */
public class P338 {


    public int[] countBits(int n) {
        return s1(n);
    }

    /**
     * dp(i) = dp(i-1)+1, i为奇
     *       = dp(i/2),   i为偶
     */
    public int[] s1(int n) {
        if (n == 0) {
            return new int[] {0};
        }

        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {

            if ((i & 1) == 1) {
                a[i] = a[i-1] + 1;
            } else {
                a[i] = a[i/2];
            }
        }

        return a;
    }


    /**
     * Java api
     */
    public int[] s2(int n) {
        if (n == 0) {
            return new int[] {0};
        }

        int[] a = new int[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Integer.bitCount(i);
        }

        return a;
    }
}
