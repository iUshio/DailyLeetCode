package dailyPromblem;

import java.util.*;

public class s131 {
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrace(s, 0);
        return res;
    }

    private void backtrace(String str, int index) {
        if (index >= str.length()) {
            res.add(new ArrayList(tmp));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (isBack(str, index, i)) {
                // 本位置是回文串
                tmp.add(str.substring(index, i + 1));
                // 回溯
                backtrace(str, i + 1);
                // 删除本位制情况
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isBack(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
