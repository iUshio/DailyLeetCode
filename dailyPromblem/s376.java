package dailyPromblem;

public class s376 {
    public int wiggleMaxLength(int[] nums) {
        // 剪枝
        if(nums.length == 1){
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int pre = 0;//记录前面的差值是正还是负
        for(int i = 1;i < nums.length;i++){
            // 比较nums[i - 1]与nums[i]的大小，判定是否是摆动的
            // 如果是的话 dp[i] = dp[i - 1] + 1
            // 如果不是的话 dp[i] = dp[i -1]
            if((nums[i] - nums[i - 1]) * pre > 0 || nums[i] == nums[i - 1]){//非摇摆
                dp[i] = dp[i - 1];
            }else{
                dp[i] = dp[i - 1] + 1;
                pre = nums[i] - nums[i - 1];
            }
        }
        return dp[nums.length - 1];
    }
}
