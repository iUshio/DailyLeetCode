package dailyPromblem;

import java.util.*;

public class s15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 第一个数大于0，直接结束
            if (nums[i] > 0) {
                return result;
            }

            // 排除重复情况
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    // 和大于0，右指针向左移动
                    right--;
                } else if (sum < 0) {
                    // 和小于0，左指针向右移动
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }

}
