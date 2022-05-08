package dailyPromblem;

import java.util.Arrays;

public class s1498 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int mod = 1000000007;
        // 2的n次方数组，方便后续计算
        int[] tmp = new int[n];
        tmp[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp[i] = (tmp[i - 1] << 1) % mod;
        }
        int res = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                // 解释一下为什么此处res是2的r-l次方
                // 当nums[l] + nums[r]时，固定最小值即nums[l]，剩下r-l个数
                // 这r-l个数每个都可以作为max，又因为min+max <= target，所以取2的r-l次方
                res = (res + tmp[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}
