package jswang.Knapsack1_0;

/**
 * Created by JiashuoWang on 10/4/14.
 */
public class Solution {
    void Knapsack(int totalV, int[] v, int[] w) {
        int[] state;
        int totalN = v.length;
        for (int i = 0; i < totalN; i++) {
            for (int j = 0; j < totalV; j++) {
                if (i == 0 && j == 0) continue;
                if (totalV - j < v[i]) state[j] = state[j - 1];
                else state[j] = state[j - 1] > state[j - v[i]] + w[i] ? state[j - 1] : state[j - v[i]] + w[i];
            }
        }
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        int totalV = 6;
        int totalN = 4;
        int[] v = new int[totalN];
        int[] w = new int[totalN];
        s.Knapsack(totalV, v, w);
    }
}
