package dailyPromblem;

public class aimAtOffer_42 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }

        int res = nums[0],tmp = 0;
        for(int i = 0; i < len; i++){
            tmp += nums[i];
            res = Math.max(res, tmp);
            if(tmp < 0){
                tmp = 0;
            }
        }

        return res;
    }
}
