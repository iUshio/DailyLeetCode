package dailyPromblem;

public class s48 {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len - i - 1; j++) {
                // 执行四次交换，结束时刚好轮回回来
                int tmp = matrix[len - 1 - j][i];
                for (int k = 0; k < 4; k++) {
                    int tmp1 = matrix[i][j];
                    matrix[i][j] = tmp;
                    tmp = tmp1;
                    tmp1 = i;
                    i = j;
                    j = len - 1 - tmp1;
                }

            }
        }
    }
}
