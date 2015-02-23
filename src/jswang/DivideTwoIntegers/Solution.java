package jswang.DivideTwoIntegers;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by willwjs on 2/22/15.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 && dividend > 0)
            return Integer.MAX_VALUE;
        else if (divisor == 0 && dividend < 0)
            return Integer.MIN_VALUE;
        else if (divisor == 0 && dividend == 0)
            return 0;

        boolean positive = false;
        if (dividend > 0 && divisor > 0) {
            dividend = 0 - dividend;
            divisor = 0 - divisor;
            positive = true;
        }
        else if (dividend < 0 && divisor < 0)
            positive = true;
        if (dividend > 0)
            dividend = 0 - dividend;
        if (divisor > 0)
            divisor = 0 - divisor;

        int quotient = 0;
        for (; dividend < 0; dividend -= divisor)
            --quotient;

        if (positive && quotient != Integer.MIN_VALUE)
            return  0 - quotient;
        else if (positive && quotient == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        else
            return quotient;
    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divide(Integer.MIN_VALUE, 0));
    }
}