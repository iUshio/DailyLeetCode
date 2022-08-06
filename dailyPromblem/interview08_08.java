package dailyPromblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class interview08_08 {

    boolean[] used;
    static int len;
    char[] strs;
    List<String> res = new LinkedList<>();

    public String[] permutation(String S) {
        len = S.length();
        strs = S.toCharArray();
        // 进行排序
        Arrays.sort(strs);

        used = new boolean[len];

        backtrace(0, "");

        return res.toArray(new String[res.size()]);
    }

    private void backtrace(int index, String str) {
        if (str.length() == len) {
            res.add(str);
            return;
        }

        for (int i = 0; i < len - str.length(); i++) {
            // 不处理访问过的位置
            if (used[index]) {
                i--;
                index = (index + 1) % len;
                continue;
            }
            // 处理重复的情况
            if (index > 0 && used[index - 1] == false && strs[index - 1] == strs[index]) {
                index = (index + 1) % len;
                continue;
            }

            used[index] = true;

            backtrace((index + 1) % len, str + strs[index]);

            used[index] = false;
            index = (index + 1) % len;

        }
    }
}
