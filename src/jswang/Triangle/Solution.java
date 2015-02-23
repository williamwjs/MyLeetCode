package jswang.Triangle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by willwjs on 2/22/15.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] history = new int[triangle.size() + 1];
        for (int i = 0; i < history.length; ++i)
            history[i] = Integer.MAX_VALUE;
        history[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); ++i) {
            for (int j = triangle.get(i).size() - 1; j > 0; --j) {
                if (history[j] < history[j - 1])
                    history[j] = history[j] + triangle.get(i).get(j);
                else
                    history[j] = history[j - 1] + triangle.get(i).get(j);
            }
            history[0] += triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i : history)
            if (min > i)
                min = i;
        return min;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(-1);
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(-2);
        list2.add(-3);
        triangle.add(list1);
        triangle.add(list2);
        System.out.println(sol.minimumTotal(triangle));
    }
}