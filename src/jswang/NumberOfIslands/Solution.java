package jswang.NumberOfIslands;

/**
 * Created by willwjs on 5/11/15.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (visited[i][j] || grid[i][j] == '0')
                    continue;
                res++;
                findIsland(i, j, grid, visited);
            }
        }
        return res;
    }

    private void findIsland(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            if (grid[i - 1][j] == '1')
                findIsland(i - 1, j, grid, visited);
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            if (grid[i][j - 1] == '1')
                findIsland(i, j - 1, grid, visited);
        }
        if (j + 1 < grid[0].length && !visited[i][j + 1]) {
            if (grid[i][j + 1] == '1')
                findIsland(i, j + 1, grid, visited);
        }
        if (i + 1 < grid.length && !visited[i + 1][j]) {
            if (grid[i + 1][j] == '1')
                findIsland(i + 1, j, grid, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}}));
    }
}