package dailyPromblem;

import java.util.*;

public class s417 {
    int[][] height;
    int rows;
    int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        height = heights;
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        // 从各海洋边界开始探寻
        for (int i = 0; i < rows; i++) {
            backtrace(i, 0, pac);
        }
        for (int j = 1; j < cols; j++) {
            backtrace(0, j, pac);
        }
        for (int i = 0; i < rows; i++) {
            backtrace(i, cols - 1, atl);
        }
        for (int j = 0; j < cols - 1; j++) {
            backtrace(rows - 1, j, atl);
        }

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pac[i][j] && atl[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private void backtrace(int row, int col, boolean[][] ocean) {
        // 这个节点之前已访问过且可以到达海洋边界
        if (ocean[row][col]) {
            return;
        }
        // 因为是从边界过来所以能到达这个节点就说明能到海边
        ocean[row][col] = true;

        // 上下左右探寻
        // 上
        if (row - 1 >= 0 && height[row - 1][col] >= height[row][col]) {
            backtrace(row - 1, col, ocean);
        }
        // 下
        if (row + 1 < rows && height[row + 1][col] >= height[row][col]) {
            backtrace(row + 1, col, ocean);
        }
        // 左
        if (col - 1 >= 0 && height[row][col - 1] >= height[row][col]) {
            backtrace(row, col - 1, ocean);
        }
        // 右
        if (col + 1 < cols && height[row][col + 1] >= height[row][col]) {
            backtrace(row, col + 1, ocean);
        }
    }

}
