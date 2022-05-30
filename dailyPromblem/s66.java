package dailyPromblem;

import java.util.*;;

public class s66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1]++;
        // 判断合法性
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] > 9) {
                if (i > 0) {
                    digits[i] -= 10;
                    digits[i - 1]++;
                } else {
                    // 拓宽数组
                    int[] res = new int[len + 1];

                    for (int j = 0; j < len; j++) {
                        res[j + 1] = digits[j];
                    }
                    res[0] = 1;
                    res[1] -= 10;
                    return res;
                }
            }
        }
        return digits;
    }
}
