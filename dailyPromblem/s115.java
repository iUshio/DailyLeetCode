package dailyPromblem;

public class s115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n)
            return 0;

        int[][] dp = new int[n][m];// 以t为纵轴，s为横轴
        // 当t为空时，全部符合条件，值为1，即dp[0][]值为1
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        // dp数组，推导公式：
        // s[j - 1] == t[i - 1]时： dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
        // s[j - 1] != t[i - 1]时：dp[i][j] = dp[i][j - 1]

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
