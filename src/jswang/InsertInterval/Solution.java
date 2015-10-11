package jswang.InsertInterval;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by willwjs on 10/11/15.
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start, end = newInterval.end;
        boolean needDo = true;
        List<Interval> res = new LinkedList<>();
        for (Interval i : intervals) {
            if (start > i.end || !needDo) {
                res.add(i);
                continue;
            }
            if (end < i.start) {
                res.add(new Interval(start, end));
                res.add(i);
                needDo = false;
                continue;
            }
            if (start <= i.end) {
                start = Math.min(i.start, start);
            }
            end = Math.max(i.end, end);
        }
        if (needDo) {
            res.add(new Interval(start, end));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1, 5));
        Interval newInterval = new Interval(6, 8);
        List<Interval> res = new Solution().insert(intervals, newInterval);
        System.out.println(res);
    }
}