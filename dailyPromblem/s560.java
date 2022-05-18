package dailyPromblem;

import java.util.*;

public class s560 {
    public int subarraySum1(int[] nums, int k) {
        if (nums.length == 1 && nums[0] != k) {
            return 0;
        } else if (nums.length == 1 && nums[0] == k) {
            return 1;
        }

        int res = 0;
        List<Integer> pre = new LinkedList<>();
        List<Integer> tmp;
        for (int i : nums) {
            tmp = new LinkedList<>();
            if (i == k) {
                res++;
            }
            for (int j : pre) {
                if (j + i == k) {
                    res++;
                }
                tmp.add(j + i);
            }
            tmp.add(i);
            pre = tmp;
        }
        return res;
    }

    // 暴力枚举
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // map辅助
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 1 && nums[0] != k) {
            return 0;
        } else if (nums.length == 1 && nums[0] == k) {
            return 1;
        }

        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i:nums){
            sum += i;
            // sum - map[j]值为k，满足条件
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            // key存放前i个数相加的综合,value存放这个和出现过多少次
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
