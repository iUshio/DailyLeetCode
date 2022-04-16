package dailyPromblem;

public class aimAtOffer_47 {

    public static void main(String[] args) {
        int[][] test = {{0}};
        System.out.println(maxValue(test));
    }

    public static int maxValue(int[][] grid) {
        if(grid.length == 0){
            return grid.length;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int left,top;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                left = j > 0? dp[i][j - 1]:0;
                top = i > 0? dp[i - 1][j]:0;
                dp[i][j] = Math.max(left, top) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];

        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) 
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                
        return grid[m - 1][n - 1];
    }
}
