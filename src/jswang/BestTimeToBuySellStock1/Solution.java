package jswang.BestTimeToBuySellStock1;

/**
 * Created by JiashuoWang on 10/13/14.
 * 首先作差分，然后转化为最大连续子序列和
 */
public class Solution {
    int maxProfit (int[] price) {
        for (int i = price.length - 1; i > 0; i--) {
            price[i] -= price[i - 1];
        }

        int[] state = new int[price.length];
        int max = 0;

        for (int i = 1; i < price.length; i++) {
            state[i] = (price[i] > price[i] + state[i - 1]) ? price[i] : price[i] + state[i - 1];
            max = (max > state[i]) ? max : state[i];
        }

        return max;
    }
}
