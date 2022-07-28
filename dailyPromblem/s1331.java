package dailyPromblem;

import java.util.*;

public class s1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        // 排序
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();

        int n = arr.length, idx = 0;
        for (int i : clone) {
            // 将序号存进去
            if (!map.containsKey(i)) map.put(i, ++idx);
        }
        
        for (int i = 0; i < n; i++) arr[i] = map.get(arr[i]);
        return arr;
    }

}
