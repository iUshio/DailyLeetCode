package dailyPromblem;

import java.util.Arrays;

public class s164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;

        for(int i = 1;i < nums.length;i++){
            res = nums[i] - nums[i - 1] > res? nums[i] - nums[i - 1]:res;
        }
        return res;
    }
}
