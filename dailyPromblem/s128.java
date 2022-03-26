package dailyPromblem;

import java.util.*;

public class s128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return 1;
        int res = 1;
        int tmp = 1;
        int len = nums.length;
        Arrays.sort(nums);

        for(int i = 1;i < len;i++){
            if(nums[i - 1] == nums[i]) continue;
            if(nums[i - 1] + 1 == nums[i]){
                tmp++;
                if(tmp > res) res = tmp;
            }else tmp = 1;
        }

        return res;
    }
}
