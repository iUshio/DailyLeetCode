package dailyPromblem;

import java.util.*;

public class s1 {
    // 暴力破解
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2]; 
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    // 哈希值
    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        // 前面存储target - nums[i]，后面存储序号
        Map<Integer,Integer> map = new HashMap<>();

        // 遍历数组
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }else{
                map.put(target - nums[i], i);
            }
        }

        return res;
    }
}
