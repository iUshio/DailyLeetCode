package dailyPromblem;

import java.util.*;

public class s442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if(len == 1){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            // 如果和上一个数相等，该数字不需要判别，或者是到最后一位
            if(i > 0 && nums[i - 1] == nums[i] || i == len - 1){
                continue;
            }
            int tmp = i + 1;
            // 比对下一位与本位置的数字，如果相等，再判别下下位是否相等
            if(nums[i] == nums[tmp]){
                tmp++;
                if(tmp >= len - 1 || nums[i] != nums[tmp]){
                    // i为倒数第二个数字，可以直接加进去
                    res.add(nums[i]);
                }
            }else{
                // 如果不相等，直接往后走
            }
        }
        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        //int cnt[] = new int[n+1];
        List<Integer> ans = new ArrayList<>();

        for(int i:nums){
            nums[(i-1)%n]=nums[(i-1)%n]+n;

        }
        for(int i=0;i<n;i++){
            if(nums[i]<3*n+1 && nums[i]>2*n){
                ans.add(i+1);
            }
        }
        return ans;

    }
}
