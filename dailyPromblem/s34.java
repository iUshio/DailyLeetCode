package dailyPromblem;

public class s34 {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int[] res = searchRange(nums, 1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        int left = 0;
        if (nums[left] == target) {
            res[0] = left;
        }
        int right = len - 1;
        if (nums[right] == target) {
            res[1] = right;
        }
        while (right >= 0 && left < len && (nums[left] != target || nums[right] != target) && right >= left) {
            if (nums[left] != target) {
                left++;
                if (left < len && nums[left] == target) {
                    res[0] = left;
                }
            }
            if (nums[right] != target) {
                right--;
                if (right >= 0 && nums[right] == target) {
                    res[1] = right;
                }
            }
        }

        return res;
    }

    // 二分法
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[] { leftIdx, rightIdx };
        }
        return new int[] { -1, -1 };
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 如果mid比target大，右指针移动到mid - 1
            // 如果mid等于target，如果是查找左边的点，应该向左收缩即右指针移动到mid - 1
            // 如果是查找右边的点，就应该移动左指针
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
