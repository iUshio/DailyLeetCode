package dailyPromblem;

import java.util.*;

public class s54 {


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int state = 0;// 四个状态，0表示向右，1表示向下，2表示向左，3表示向上
        // i表示列，j表示行
        for (int i = 0, j = 0, k = 0; k < (matrix.length * matrix[0].length); k++) {
            switch (state) {
                case 0: {
                    res.add(matrix[j][i]);
                    matrix[j][i] = Integer.MAX_VALUE;
                    // 存储完该位置向右边移动，判断右边是否越界或者访问过，则改变状态至1
                    if (i + 1 >= matrix[0].length || matrix[j][i + 1] == Integer.MAX_VALUE) {
                        state = 1;
                        j++;
                    } else {
                        i++;
                    }
                    break;
                }
                case 1: {
                    res.add(matrix[j][i]);
                    matrix[j][i] = Integer.MAX_VALUE;
                    // 存储完该位置向下边移动，判断下边是否越界或者访问过，则改变状态至2
                    if (j + 1 >= matrix.length || matrix[j + 1][i] == Integer.MAX_VALUE) {
                        state = 2;
                        i--;
                    } else {
                        j++;
                    }
                    break;
                }
                case 2: {
                    res.add(matrix[j][i]);
                    matrix[j][i] = Integer.MAX_VALUE;
                    // 存储完该位置向左边移动，判断左边是否越界或者访问过，则改变状态至3
                    if (i - 1 < 0 || matrix[j][i - 1] == Integer.MAX_VALUE) {
                        state = 3;
                        j--;
                    } else {
                        i--;
                    }
                    break;
                }
                case 3: {
                    res.add(matrix[j][i]);
                    matrix[j][i] = Integer.MAX_VALUE;
                    // 存储完该位置向上边移动，判断上边是否越界或者访问过，则改变状态至0
                    if (j - 1 < 0 || matrix[j - 1][i] == Integer.MAX_VALUE) {
                        state = 0;
                        i++;
                    } else {
                        j--;
                    }
                    break;
                }
            }
        }

        return res;
    }
}
