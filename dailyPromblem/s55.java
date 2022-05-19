package dailyPromblem;

public class s55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if( len == 1){
            return true;
        }

        int far = 0;
        int tmp = 0;
        for(int i = 0; i < len; i++){
            tmp = i + nums[i];
            far = Math.max(far,tmp);
            if(far == i){
                // 该位置为最远位置
                if(far < len - 1){
                    return false;
                }else{
                    return true;
                }
            }
            if(far >= len - 1){
                return true;
            }
        }

        return false;
    }
}
