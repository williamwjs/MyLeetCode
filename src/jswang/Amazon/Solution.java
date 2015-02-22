package jswang.Amazon;

/**
 * Created by willwjs on 2/7/15.
 */
public class Solution {
    public static void main (String[] args) {
        int num = 782, count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        System.out.print(num % count);


    }
}
