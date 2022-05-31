package dailyPromblem;

public class s329 {
    // 存储ij位置出发，递增的最长路径
    int[][] pathLen;
    int[][] matrix;
    int n, m;
    // 表示移动方向:向右，向左，向上，向下
    int[][] dires = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix_) {
        matrix = matrix_;
        m = matrix.length;
        n = matrix[0].length;
        pathLen = new int[m][n];
        int maxpath = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxpath = Math.max(maxpath, dfs(i, j));
            }
        }
        return maxpath;
    }

    // 从[i,j]出发的最长路径
    int dfs(int i, int j) {
        // 记忆化递归
        // pathLen[i][j] > 0表明已求得从(i,j)出发的最长递增路径
        if (pathLen[i][j] > 0) {
            return pathLen[i][j];
        }
        int path = 1;
        // 探索上下左右最长递增路径
        for (int[] d : dires) {
            int x = i + d[0];
            int y = j + d[1];
            // 只访问比ij大的数
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            path = Math.max(path, dfs(x, y) + 1);
        }
        pathLen[i][j] = path;
        return path;
    }
}
