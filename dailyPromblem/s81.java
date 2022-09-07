package dailyPromblem;

public class s81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target ? true : false;
        }

        for (int i = 0; i < len;) {
            if (nums[i] == target) {
                return true;
            } else if (nums[i] > target) {
                i++;
                while (i < len && nums[i] > nums[i - 1]) {
                    i++;
                }

            } else {
                i++;
            }
        }

        return false;
    }
}
