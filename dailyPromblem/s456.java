package dailyPromblem;

import java.util.*;

public class s456 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        // 记录比max大的数，即132中的3
        Deque<Integer> candidateK = new LinkedList<Integer>();
        candidateK.push(nums[n - 1]);
        // max记录132中的2
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            // 队首的元素记录最大值
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }

            // 压倒队列首部，始终保持队列首部是大于maxK的数中最远离maxK的
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }


}
