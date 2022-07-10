package dailyPromblem;

import java.util.*;;

public class s46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrace(nums, 0);
        return res;
    }

    private void backtrace(int[] nums, int index) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 循环nums.lengh - path.size次
        for (int i = 0; i < nums.length - path.size(); i++) {
            // 重置位置
            if (index >= nums.length) {
                index = 0;
            }
            // 寻找未使用位置
            while (used[index]) {
                index++;
                if (index >= nums.length) {
                    index = 0;
                }
            }

            used[index] = true;
            path.add(nums[index]);
            backtrace(nums, index + 1);
            used[index] = false;
            index++;
            path.remove(path.size() - 1);
        }
    }
}
