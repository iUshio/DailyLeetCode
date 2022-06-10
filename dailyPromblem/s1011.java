package dailyPromblem;

import java.util.Arrays;

public class s1011 {

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // shipWithinDays(weights,5);
    }

    public static int shipWithinDays1(int[] weights, int days) {
        int len = weights.length;
        if (len == 1) {
            return weights[0];
        }

        // 统计weights最大值与平均值
        int max = 0;
        int avg = 0;
        int sum = 0;
        int min = weights[0];
        for (int a : weights) {
            max = Math.max(a, max);
            sum += a;
        }
        // 向上取整
        avg = (sum + days - 1) / days;
        int res = Math.max(avg, max);
        int tmp = sum;

        // 迭代判断res是否符合条件
        while (tmp != 0) {
            int sumTmp = 0;
            int point = 1;
            tmp = 0;
            for (int i = 0; i < len; i++) {
                if (point > days) {
                    tmp += weights[i];
                } else {
                    sumTmp += weights[i];
                    if (sumTmp > res) {
                        sumTmp = weights[i];
                        point++;
                        if(point > days){
                            tmp = sumTmp;
                        }
                    }
                }
            }
            res += (tmp + days - 1) / days;
            System.out.println(res);
        }
        return res;
    }

    // 二分法查找
    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        // left为weights最大值，right为所有的和
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
