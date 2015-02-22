package jswang.WordLadder1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by willwjs on 2/22/15.
 */
public class Solution {
    private  int help(String start, String end, Set<String> dict, Set<String> visited) { //超时
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < start.length(); ++j) {
            for (int i = 0; i < 26; ++i) {
                if (start.charAt(j) == ('a' + i))
                    continue;
                String newstr = start.substring(0, j) + (char) ('a' + i)
                        + start.substring(j + 1, start.length());
                if (newstr.equals(end))
                    return 1;
                if (dict.contains(newstr) && !visited.contains(newstr)) {
                    visited.add(newstr);
                    int prev = help(newstr, end, dict, visited);
                    if (prev != 0 && prev < min)
                        min = prev + 1;
                    visited.remove(newstr);
                }
            }
        }

        if (min != Integer.MAX_VALUE)
            return min;

        return 0;
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> visited = new HashSet<String>();
        return 1 + help(start, end, dict, visited);
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("cog");
        dict.add("dot");
        dict.add("dog");
        dict.add("hit");
        dict.add("log");
        dict.add("lot");
        System.out.println(new Solution().ladderLength("hit", "cog", dict));
    }
}