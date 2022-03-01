package leet.soluiton;

/**
 * @desc: 汉明距离
 * @tag: 位运算
 */
public class P461 {
    public int hammingDistance(int x, int y) {
        return s2(x, y);
    }

    public int s1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int s2(int x, int y) {
        int z = x ^ y;

        int ans = 0;
        while (z > 0) {
            if ((z & 1) == 1) {
                ans++;
            }
            z >>= 1;
        }

        return ans;
    }
}
