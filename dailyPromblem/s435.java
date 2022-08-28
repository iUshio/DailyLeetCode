package dailyPromblem;

import java.util.*;

public class s435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] nums1, int[] nums2) {
                if (nums1[0] != nums2[0]) {
                    return nums1[0] - nums2[0];
                } else {
                    return nums1[1] - nums2[1];
                }
            }
        });

        int right = intervals[0][1], res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < right) {
                res++;
                right = Math.min(right,intervals[i][1]);
            }else{
                right = intervals[i][1];
            }
        }
        return res;
    }
}
