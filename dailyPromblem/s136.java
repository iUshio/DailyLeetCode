package dailyPromblem;

public class s136 {
    public int singleNumber(int[] nums) {
        // 异或
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
