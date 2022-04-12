package dailyPromblem;

public class s53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int res = nums[0];
        int tmp = 0;
        // tmp在小于0的时候应该抛弃，因为这样会使得后面更大的数字变小
        // 未小于0是tmp不应该被抛弃，因为这会使得后面的数字变大（如果有的话）
        for(int i = 0;i < len;i++){
            tmp += nums[i];
            res = Math.max(tmp, res);
            if(tmp < 0){
                tmp = 0;
            }
        }
        return res;
    }
    // 动态规划版本
    public int maxSubArray2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1;i < len;i++){
            // 状态转移公式
            // dp[i - 1] + nums[i]表示不舍弃前面的求和，因为res始终保持最大，不需要担心是否出现负数在后边的情况
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > res) res = dp[i]; // result 保存dp[i]的最大值
        }
        return res;
    }
}
