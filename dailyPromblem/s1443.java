package dailyPromblem;

import java.util.*;

public class s1443 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        boolean[] visited = new boolean[n];
        // 存储图
        for (int[] v : edges) {
            int a = v[0];
            int b = v[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        return dfs(list, hasApple, visited, 0)[0];
    }

    private int[] dfs(List<List<Integer>> list, List<Boolean> hasApple, boolean[] visited, int index) {
        int res = 0; // 记录已行走的路径
        int nodeCount = 0; // 记录已经访问了多少个有苹果的结点
        visited[index] = true; // 如果访问过这个结点，不再进行访问

        for (int dx : list.get(index)) {
            if (visited[dx])
                continue;

            // 遍历子结点
            int[] v = dfs(list, hasApple, visited, dx);
            // 如果该子结点的孩子没有苹果，则res不参与计算
            if (v[1] == 0)
                res += 0;
            else {
                res += v[0] + 2;
                nodeCount += v[1];
            }
        }
        if (hasApple.get(index))
            nodeCount++;
        return new int[] { res, nodeCount };
    }

}
