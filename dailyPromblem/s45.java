package dailyPromblem;

public class s45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        // res存放到达i位置最少跳跃数
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            // 更新res
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (res[j] == 0) {
                    // 此位置没有访问过
                    res[j] = res[i] + 1;
                }
            }
        }
        return res[len - 1];
    }

    public int jump2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        // 记录跳跃的次数
        int count = 0;
        // 当前的覆盖最大区域
        int curDistance = 0;
        // 最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < len; i++) {
            // 在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= len - 1) {
                count++;
                break;
            }
            // 走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
