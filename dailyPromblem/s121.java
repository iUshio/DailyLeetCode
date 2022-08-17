package dailyPromblem;

public class s121 {
    public int maxProfit(int[] prices) {
        int res = 0,pre = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - pre > res){
                // 卖出这天的股票
                res = prices[i] - pre;
            }else if(prices[i] < pre){
                // 当天股票更便宜则不可能卖出
                pre = prices[i];
            }
        }
        return res;
    }
}
