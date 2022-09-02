package dailyPromblem;

import java.util.*;

public class s1030 {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[] { i, j };
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))
                        - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter));
            }
        });
        return ret;
    }
}
