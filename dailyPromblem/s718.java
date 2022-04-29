package dailyPromblem;

public class s718 {

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length + 1;
        int len2 = nums2.length + 1;
        int res = 0;
        int[][] dp = new int[len1][len2];
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = res > dp[i][j]? res:dp[i][j];
            }
        }
        return res;
    }

    public int findLength2(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
