package dailyPromblem;

public class s300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 1;
        int[] dp = new int[len];

        int res = 0;
        for(int i = 0; i < len; i++){
            dp[i] = 1;
            // 一层一层找到前面比nums[i]小的数，加入到该数的子序列中
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        
        return res;
    }
}
