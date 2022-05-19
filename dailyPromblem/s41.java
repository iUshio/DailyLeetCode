package dailyPromblem;

public class s41 {
    public int firstMissingPositive(int[] nums) {
        // 长度为n的数组没有出现的最小正整数只能在1~n+1中
        // 这是因为这个数组最多只能填满1~n，答案就是没在1~n中出现的数字或者n+1
        int n = nums.length;
        // 将小于0的数编程n+1
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 将1~n中出现的数字做标记即置负，num[num[i]]
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 查找第一个非负数，这个数的下表+1就是没有出现1~n的数字即没有出现的最小正整数
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 1~n都出现了，返回n+1
        return n + 1;
    }

}
