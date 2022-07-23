package dailyPromblem;

import java.util.*;

public class s354 {
    // 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，
    // 则按照高度 h 降序排序。之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案。
    // 原因，避免(5,2)，(5,4)这样的情况造成干扰

    // 方法1，动态规划：超时
    public int maxEnvelopes1(int[][] envelopes) {
        int len = envelopes.length;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        // 只能把点数小的牌压到点数比它大的牌上
        // 如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去
        // 如果当前牌有多个堆可供选择，则选择最左边的那一堆放置
        // 按照上述规则执行，可以算出最长递增子序列，牌的堆数就是最长递增子序列的长度
        // 为什么？ 下一个牌堆必定能拿出一个数，这个数在上一个牌堆某个数的右边且大于这个数
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            // 牌堆顶的数字是有序的，最右边排队顶的数字最大
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
