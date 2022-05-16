package dailyPromblem;

import java.util.Arrays;

public class s189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        rotate(nums, 4);
        for(int i:nums){
            System.out.println(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        // 如果k >= len数组进行反转
        if(k == 0){
            return;
        }

        int[] tmp = Arrays.copyOf(nums, len);
        
        for(int i = 0; i < len; i++){
            nums[(i + k)%len] = tmp[i];
        }
        
    }
}
