package dailyPromblem;

public class s528 {
    // 前缀和 + 二分
    class Solution {
        int[] sum;
        public Solution(int[] w) {
            int n = w.length;
            sum = new int[n];
            sum[0] = w[0];
            for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + w[i];
            // 该方法计算后[sum[i - 1],sum[i]]表示w[i]的概率区间
        }
        
        public int pickIndex() {
            int n = sum.length;
            // 生成[1,total]之间的一个整数
            int t = (int) (Math.random() * sum[n - 1]) + 1;
            int l = 0, r = n - 1;
            // 二分法
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (sum[mid] >= t) r = mid;
                else l = mid + 1;
            }
            return l;
        }
    }
}
