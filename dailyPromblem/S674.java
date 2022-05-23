package dailyPromblem;

/**
 * S674
 */
public class S674 {

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        
        int res = 0;
        int tmp = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] > nums[i - 1]){
                tmp++;
            }else{
                // 更新res
                res = Math.max(res,tmp);
                // 更新tmp
                tmp = 1;
            }
        }
        res = Math.max(res,tmp);
        return res;
    }
}