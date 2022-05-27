package dailyPromblem;

public class s695 {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 只访问1的，减少访问次数
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        // 访问过的设置为0，下次不再访问
        grid[x][y] = 0;
        int sum = 1;
        // 向四个方向发散求和
        sum += dfs(grid, x - 1, y);
        sum += dfs(grid, x + 1, y);
        sum += dfs(grid, x, y - 1);
        sum += dfs(grid, x, y + 1);
        return sum;
    }

}
