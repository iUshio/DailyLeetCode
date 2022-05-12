package dailyPromblem;

import java.util.*;

public class s57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0)
            return intervals;
        if (intervals.length == 0)
            return new int[][] { newInterval };
        List<int[]> res = new LinkedList<>();

        int left = newInterval[0], right = newInterval[1];
        int k = 0, len = intervals.length;
        // 在重叠范围前面，直接加入
        while (k < len && intervals[k][1] < left) {
            res.add(intervals[k++]);
        }
        // 处理重叠范围
        while (k < len && intervals[k][0] <= right) {
            left = left <= intervals[k][0] ? left : intervals[k][0];
            right = right >= intervals[k][1] ? right : intervals[k][1];
            k++;
        }
        res.add(new int[] { left, right });
        // 在重叠范围之后，直接加入
        while (k < len) {
            res.add(intervals[k++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
