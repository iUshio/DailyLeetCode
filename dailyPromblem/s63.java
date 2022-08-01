package dailyPromblem;

public class s63 {
    static int rows;
    static int cols;

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? -1 : obstacleGrid[i][j];
            }
        }

        int res = backtrace(obstacleGrid, 0, 0);
        return res >= 0 ? res : 0;
    }

    private static int backtrace(int[][] obstacleGrid, int row, int col) {
        if (!isRight(obstacleGrid, row, col)) {
            // 不合规
            return -1;
        }

        // 判断是否到达终点
        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }

        // 如果该位置已探寻
        if (obstacleGrid[row][col] > 0) {
            return obstacleGrid[row][col];
        }

        // 向右走
        int right = backtrace(obstacleGrid, row, col + 1);
        // 向下走
        int down = backtrace(obstacleGrid, row + 1, col);

        if (right < 0 && down < 0) {
            // 向右和向下都无法到达
            obstacleGrid[row][col] = -1;
            return -1;
        } else {
            right = right > 0 ? right : 0;
            down = down > 0 ? down : 0;
            obstacleGrid[row][col] = right + down;
            return obstacleGrid[row][col];
        }
    }

    // 判断当前移动位置是否合理
    private static boolean isRight(int[][] obstacleGrid, int row, int col) {
        // 是否超出边界
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return false;
        }

        // 是否是障碍物
        if (obstacleGrid[row][col] == -1) {
            obstacleGrid[row][col] = -1;
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        for (int[] a : obstacleGrid) {
            for (int b : a) {
                System.out.print(b);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

}
