package dailyPromblem;

public class s70 {
    // 动态规划，除开第0步和第一步，剩余的楼梯都是n-1层楼梯走一步或者n-2层楼梯走两步到达
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
