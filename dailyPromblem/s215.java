package dailyPromblem;

import java.util.*;;

public class s215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        // 对数组进行排序
        Arrays.sort(nums);
        return nums[len - k];
    }
}
