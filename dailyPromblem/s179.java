package dailyPromblem;

import java.util.*;

public class s179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));

        if (strs[nums.length - 1].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            res.append(strs[i]);
        }

        return res.toString();
    }
}
