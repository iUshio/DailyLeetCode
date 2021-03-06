package dailyPromblem;

import java.util.*;

public class s986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();
        if (firstList.length == 0 && secondList.length == 0) {
            return res.toArray(new int[res.size()][]);
        }

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) {
                // 如果有交集
                res.add(new int[] { lo, hi });
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
