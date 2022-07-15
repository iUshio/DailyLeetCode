package dailyPromblem;

public class s375 {
    public int getMoneyAmount(int n) {
        // n + 2为防止猜测最右侧数字越界
        int[][] dp = new int[n + 2][n + 1];
        for (int l = n; l >= 1; l--) {
            for (int r = 1; r <= n; r++) {
                // 猜测范围小于等于1，dp[l][r]值为0，能够直接猜中
                if (r <= l)
                    continue;
                // 猜测范围大于1
                int minCost = Integer.MAX_VALUE;
                for (int i = l; i <= r; i++) {
                    // 如果当前第一个猜测的数是i，计算：猜测左右两边到只有1个数需要消耗多少
                    int cost = i + Math.max(dp[l][i - 1], dp[i + 1][r]);
                    // 取当前猜测范围最小的代价
                    minCost = Math.min(cost, minCost);
                }
                // 记录最小代价
                dp[l][r] = minCost;
            }

        }
        return dp[1][n];
    }

    // 递归做法
    public int getMoneyAmount1(int n) {
        int[][] dp = new int[n + 1][n + 1];

        return backtrace(dp, 1, n);
    }

    private int backtrace(int[][] dp, int left, int right) {
        // 如果猜测范围小于等于1
        if (left >= right)
            return 0;

            // 如果访问过这个位置，直接返回结果
        if(dp[left][right] != 0)
            return dp[left][right];

        // 记录最小代价
        int res = Integer.MAX_VALUE;
        // 依次计算当前范围第一次猜测某个数的最小代价
        for (int i = left; i < right; i++) {
            int cost = i + Math.max(
                    backtrace(dp, left, i - 1),
                    backtrace(dp, i + 1, right));
            res = Math.min(res, cost);
        }

        // 记录最小代价
        dp[left][right] = res;

        return res;
    }
}
