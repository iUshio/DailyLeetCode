package dailyPromblem;

public class s200 {

    public int numIslands(char[][] grid) {
        int res = 0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    tracing(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    // 对某个岛屿进行遍历，将走过的位置变为0
    private void tracing(char[][] grid, int row, int col) {
        // 检查合法性（上下左右是否越界，值是否为0）
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // 走过本位置，将值置为0
        grid[row][col] = '0';

        // 上下左右探寻
        // 往上探寻
        tracing(grid, row - 1, col);
        // 往下探寻
        tracing(grid, row + 1, col);
        // 往左探寻
        tracing(grid, row, col - 1);
        // 往右探寻
        tracing(grid, row, col + 1);
    }
}
