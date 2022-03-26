package dailyPromblem;

import java.util.*;

public class s78 {

    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrace(0, nums);
        return res;
    }

    public void backtrace(int index,int[] nums){
        res.add(new ArrayList<>(path));
        if(index >= nums.length){
            return;
        }

        for(int i = index;i < nums.length;i++){
            path.add(nums[i]);
            backtrace(i + 1, nums);
            path.remove(path.size() - 1);

        }
    }
}
