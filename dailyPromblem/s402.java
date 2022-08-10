package dailyPromblem;

import java.util.*;

public class s402 {

    public static void main(String[] args) {
        String num = "1432219";
        System.out.println(removeKdigits1(num, 3));
    }

    // 超时
    public static String removeKdigits1(String num, int k) {
        int len = num.length();
        if (k >= len) {
            return "" + 0;
        }

        // 存储上一行dp
        String[] dps = new String[len + 1];
        String tmp = "" + 0;
        Arrays.fill(dps, tmp);

        for (int i = 1; i <= len; i++) {
            // 存储本行dp
            String[] tmpDp = new String[len + 1];
            Arrays.fill(tmpDp, tmp);
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    tmpDp[j] = dps[j] + num.charAt(i - 1);
                } else {
                    // 情况分为删除这个位置的数即： dp[i - 1][j - 1]
                    // 不删除这个位置的数： dp[i - 1][j] * 10 + nums[i]
                    String tmp1 = dps[j] + num.charAt(i - 1);
                    String tmp2 = dps[j - 1];
                    tmpDp[j] = tmp1.compareTo(tmp2) > 0 ? tmp2 : tmp1;
                }
            }
            dps = tmpDp;
        }

        StringBuilder sb = new StringBuilder(dps[k]);
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
