package dailyPromblem;

import java.util.*;

public class s658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer> res = new LinkedList<>();
        if (len == 1) {
            res.add(arr[0]);
            return res;
        }

        // 先加入k个数

        for (int i = 0; i < k; i++) {
            res.add(arr[i]);
        }

        for (int i = res.size(); i < len; i++) {
            // 判断当前的数与res中第一个数与x的距离
            int re1 = Math.abs(arr[i] - x);
            int re2 = Math.abs(res.get(0) - x);
            if (re2 > re1) {
                // 移出res第一个
                res.remove(0);
                res.add(arr[i]);
            }
        }

        return res;
    }
}
