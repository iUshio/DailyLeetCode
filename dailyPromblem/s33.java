package dailyPromblem;

public class s33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1){
            return nums[0] == target?0:-1;
        }

        for(int i = 0; i < len;){
            if(nums[i] == target){
                return i;
            }else if(nums[i] > target){
                i++;
                while(i < len && nums[i] > nums[i - 1]){
                    i++;
                }

            }else{
                i++;
            }
        }

        return -1;
    }
}
