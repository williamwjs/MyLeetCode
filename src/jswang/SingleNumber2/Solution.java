package jswang.SingleNumber2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by willwjs on 11/18/14.
 */
public class Solution {
    public int singleNumber(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int tmp = A[0];
        set.add(A[0]);
        for (int i = 1; i < A.length; ++i) {
            if (set.contains(A[i]))
                set.remove(A[i]);
            else {
                tmp ^= A[i];
                set.add(A[i]);
            }
        }
        return tmp;
    }

    public static void main (String[] args) {
        Solution sol = new Solution();
        int[] A = {3, 2, 3, 1, 2, 3, 2};
        System.out.println(sol.singleNumber(A));
    }
}
