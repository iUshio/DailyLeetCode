package dailyPromblem;

public class s122 {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len == 1){
            return 0;
        }
        int[] dp = new int[len];
        for(int i = 1;i < len;i++){
            if(prices[i - 1] < prices[i]){
                // 卖出股票
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            }else{
                // 不卖出股票
                dp[i] = dp[i - 1];
            }
        }

        return dp[len - 1];
    }

    public int maxProfit(int[] prices) {
        int len = prices.length,res = 0,pre = prices[0];
        for(int i = 1; i < len; i++){
            if(prices[i] > pre){
                // 卖出股票
                res += prices[i] - pre;
            }
            pre = prices[i];
        }

        return res;
    }

}
