package dailyPromblem;

import java.util.*;

public class s56 {
    public int[][] merge1(int[][] intervals) {
        int len = intervals.length;
        if (len == 1)
            return intervals;

        // 对intervals进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] tmp = res.get(res.size() - 1);
            if (intervals[i][0] <= tmp[1]) {
                tmp[0] = Math.min(tmp[0], intervals[i][0]);
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
                res.remove(res.size() - 1);
                res.add(tmp);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1)
            return intervals;

        // 对intervals进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new LinkedList<>();
        int start = intervals[0][0];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] > intervals[i - 1][1]) {
                // 两区间不相交，将i - 1的区间加入到结果中
                res.add(new int[] { start, intervals[i - 1][1] });
                // 更新start
                start = intervals[i][0];
            } else {
                // 合并两区间
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            }
        }

        res.add(new int[] { start, intervals[len - 1][1] });

        return res.toArray(new int[res.size()][]);
    }
}
