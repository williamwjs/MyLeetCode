package jswang.maxPoints;

/**
 * Created by Jiashuo Wang on 14-6-10.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    private class DisjointSet {
        private int[] set;
        DisjointSet(int n) {
            set = new int[n];
            for(int i = 0; i < n; i++)
                set[i] = -1;
        }
        int find(int elem) {
            if(set[elem] < 0) return elem;
            else return find(set[elem]);
        }
        void union(int elem1, int elem2) {
            if(find(elem1) != find(elem2)) {
                set[find(elem1)] += set[find(elem2)];
                set[find(elem2)] = find(elem1);
            }
        }
        int findMax() {
            int max = 0;
            for(int tmp : set)
                if(tmp < max) max = tmp;
            return 0 - max;
        }
    }
    public int maxPoints(Point[] points) {
        DisjointSet js = new DisjointSet(points.length*2);
        for(int i = 1; i < points.length; i++) {
            for(int j = 0; j < i; j++) {
                if(points[i].x == points[j].x)
                    js.union(i, j);
                if(points[i].y == points[j].y)
                    js.union(points.length+i, points.length+j);
            }
        }
        return js.findMax();
    }
}