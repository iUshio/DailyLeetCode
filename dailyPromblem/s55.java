package dailyPromblem;

public class s55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return true;
        }
        // 记录最远能到达的位置
        int distance = nums[0];
        // 只访问到distance
        for(int i = 0; i <= distance; i++){
            distance = Math.max(distance,i + nums[i]);
            // 到达目的地
            if(distance >= len - 1){
                return true;
            }
        }
        return false;
    }
}
