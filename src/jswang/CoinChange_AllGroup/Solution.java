package jswang.CoinChange_AllGroup;

/**
 * Created by JiashuoWang on 10/11/14.
 */
public class Solution {

    int coinGroupRC (int[] s, int m, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m < 0)
            return 0;
        return coinGroupRC(s, m - 1, n) + coinGroupRC(s, m, n - s[m]);
    }

    void coinGroupDP (int[] s, int n) {
        int[] state = new int[s.length];
    }

    /*
    * Wrong Answer:
    * 3: {3}, {2, 1}, {1, 1, 1}
    * 4: {3, 1}, {2, 1, 1}, {1, 1, 1, 1}; {2, 1, 1}, {1, 1, 2}, {2, 2}, {2, 2}
    */
    /*int[] state = new int[n + 1];

    for (int m : s) {
        state[m]++;
    }

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= i / 2; j++) {
            state[i] += state[j] * state[i - j];
        }
    }
    System.out.println(state[n]);*/

    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] s = {1, 2, 3};
        int n = 4;
        System.out.println("Recursive: " + sol.coinGroupRC(s, s.length - 1, n));
        System.out.print("Dynamic Programming: ");
        sol.coinGroupDP(s, n);
    }
}
