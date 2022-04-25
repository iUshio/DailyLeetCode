package dailyPromblem;

import java.util.*;

public class s25 {
    public int totalNQueens(int n) {
        // 记录竖行位置是否放了
        Set<Integer> columns = new HashSet<Integer>();
        // 记录左斜行是否放了（从左下往右上走）
        Set<Integer> diagonals1 = new HashSet<Integer>();
        // 记录右斜行是否放了（从左上往右下走）
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                // 纵向没有皇后
                if (columns.contains(i)) {
                    continue;
                }
                // 判断斜方向上没有皇后
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}
