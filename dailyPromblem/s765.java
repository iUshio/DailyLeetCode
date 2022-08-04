package dailyPromblem;

import java.util.*;

public class s765 {
    public int minSwapsCouples(int[] row) {
        // f存储上一个未配对的数
        int f = row[0];
        // 因为只对第二个数a进行操作，map中键值为上一个未配对数所需配对的数b
        // 表示找到b的话将其与a进行交换即可完成b组配对
        // 所以如果在遍历中遇到b，则只需考虑当前位置为a时的情况
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < row.length; i++) {
            int n = row[i];

            while (map.containsKey(n)) {
                n = map.get(n);
            }
            // 如果是一个偶数^1,那么答案是偶数+1.如果是一个奇数^1,那么答案是奇数-1
            // 后一个判断是否是同组
            // 一两个数为一组，移动第一个数与移动第二个数的次数是一样的，所以默认采用移动第二个数
            // 如果第二个数与上一个未配对的数不是同一组，则说明这个数需要移动
            if (i % 2 != 0 && n != (f ^ 1)) {
                map.put(f ^ 1, n);
            }

            f = n;
        }

        // 有n对数未配对则移动n次
        return map.size();
    }

}
