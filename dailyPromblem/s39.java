package dailyPromblem;

import java.util.*;

public class s39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }

    public void backtrace(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝（因为已经排过序，如果当前的数字加起来都大了，后续的肯定也大，故直接跳出去）
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
