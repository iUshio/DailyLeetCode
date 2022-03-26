package dailyPromblem;

import java.util.*;

/**
 * interview08.12
 */
public class interview08_12 {

    static List<String> path = new LinkedList<>();
    static List<List<String>> res = new ArrayList<>();
    static int[] used;// 表示此位置使用情况

    public static void main(String[] args) {
        System.out.println(solveNQueens(5));
    }

    public static List<List<String>> solveNQueens(int n) {

        if(n == 1){
            path.add("Q");
            res.add(new ArrayList<>(path));
            return res;
        }

        used = new int[n];
        backTrace(n, 0);
        return res;
    }

    public static void backTrace(int n, int index) {// index表示第多少行,从0开始
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(i, index, n))
                continue;

            String tmp = new String();
            for (int k = 0; k < i; k++) {
                tmp += ".";
            }
            tmp += "Q";
            for (int k = i + 1; k < n; k++) {
                tmp += ".";
            }

            used[index] = i + 1;
            path.add(tmp);
            backTrace(n, index + 1);
            path.remove(path.size() - 1);
            used[index] = 0;
        }
    }

    public static boolean isValid(int i, int index, int n) {

        for (int a : used) {// 检查列
            if(a == 0) continue;
            if(a == i + 1) return false;
        }
        for (int k = 0; k < n; k++) {// 检查对角线
            if(used[k] == 0) continue;
            if (i + 1 == (used[k] + index - k) || i + 1 == (used[k] - index + k))
                return false;
        }
        return true;
    }
}