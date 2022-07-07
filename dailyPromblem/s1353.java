package dailyPromblem;

import java.util.*;

public class s1353 {

    public int maxEvents(int[][] events) {
        // 首先排序：开始时间小的在前。这样是方便我们顺序遍历，把开始时间一样的都放进堆
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        // 一天天遍历，当天及当天之前开始的会议进入队列排队，去除已经结束的会议
        // 队列头部是最早结束的会议
        while (i < n || !pq.isEmpty()) {
            // 将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            // pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            // 顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }
}
