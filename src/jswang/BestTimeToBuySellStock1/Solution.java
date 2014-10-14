package jswang.BestTimeToBuySellStock1;

/**
 * Created by JiashuoWang on 10/13/14.
 */
//贪婪算法
public class Solution {
    int maxProfit (int[] prices) {
        if (prices.length < 2) return 0;

        int minbuy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = (profit > prices[i] - minbuy) ? profit : prices[i] - minbuy;
            minbuy = (minbuy < prices[i]) ? minbuy : prices[i];
        }

        return profit;
    }
}

//DP,首先作差分，然后转化为最大连续子序列和
class Solution2 {
    int maxProfit (int[] price) {
        if (price.length < 2) return 0;

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
