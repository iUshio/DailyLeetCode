package dailyPromblem;

/**
 * interview17_24
 */
public class interview17_24 {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 1, 0 }, { 2, 1, -1, 1 }, { 0, 1, 2, -1 } };
        for (int a : getMaxMatrix1(matrix)) {
            System.out.print(a);
        }

    }

    public static int[] getMaxMatrix1(int[][] matrix) {
        int collen = matrix.length;// 行
        int rowlen = matrix[0].length;// 列
        if (collen == 1 && rowlen == 1) {
            return new int[] { 0, 0, 0, 0 };
        }
        int summax = Integer.MIN_VALUE;
        int[] res = { 0, 0, 0, 0 };
        int[] sums = null;
        int tmp, start;

        for (int i = 0; i < collen; i++) {
            sums = new int[rowlen];
            for (int j = i; j < collen; j++) {
                // 列方向上(i,j)的计算情况
                tmp = 0;// 当前最大值
                start = 0;// 最大值起始位置
                // 计算每一列上sums的值
                for (int k = 0; k < rowlen; k++) {
                    sums[k] += matrix[j][k];
                    tmp += sums[k];
                    if (tmp > summax) {
                        summax = tmp;
                        res[0] = i;
                        res[1] = start;
                        res[2] = j;
                        res[3] = k;
                    }
                    if (tmp < 0) {
                        tmp = 0;
                        start = k + 1;
                    }
                }

            }
        }
        // System.out.println(summax);
        return res;
    }

    public static int[] getMaxMatrix2(int[][] matrix) {
        /*
         * 降维打击+求连续子序列的和最大值:
         * [[1,2,1,0],
         * [2,1,-1,1],
         * [0,1,2,-1]]
         * 首先遍历出所有的连续行的组合状况[i,j],其中i<=j
         * 上述例子就是:[0,0],[0,1],[0,2],[1,1],[1,2][2,2]这6种状况
         * 设矩阵有M行N列
         * 用一个长度为N的数组sum[N]存储[i,j]连续行内的每一列的和
         * 如:[0,2]行内的sum[0]=3,sum[1]=4,sum[3]=-1,sum[4]=2
         * 此时问题就转化为了求sum的连续子序列和的最大值
         * 此时还要维护的是子矩阵的左上角和右下角的坐标
         * 时间复杂度:O(M*N^2);空间复杂度:O(N)
         */
        int M = matrix.length, N = matrix[0].length;
        // 结果
        int[] res = new int[] { -1, -1, 200, 200 };
        // 维护子矩阵和的最大值
        int max = Integer.MIN_VALUE;
        // sum存储[i,j]连续行内的每一列的和(动态计算)
        long[] sum = null;
        int startCol = 0, dp = 0;
        // 遍历所有连续行的组合,起始行范围为:[0, M-1]
        for (int i = 0; i < M; i++) {
            // 每当i(起始行)的位置改变就要重新计算sum
            sum = new long[N];
            // 末尾行的范围为:[i, M-1]
            for (int j = i; j < M; j++) {
                // 重新开始一行就要刷新起始列位置为0,因为dp也在此时进行刷新
                // 换句话说就是接下来计算得到的dp>max时,默认都是从第0列开始计算的
                startCol = 0;
                // dp表示以k结尾的sum数组连续子序列和的最大值,新起一列当然要重新来算
                // 也可以这么理解,子矩阵和就是一维数组sum[k]的和,一行即可
                dp = 0;
                // k表示遍历matrix[j]的每一个元素matrix[j][k]的索引,范围:[0,N-1]
                for (int k = 0; k < N; k++) {
                    // 计算新一行的sum[k]
                    sum[k] += matrix[j][k];
                    // 先计算dp[k],假设要了sum[k]
                    dp += sum[k];
                    // 若dp>max表明当前的子矩阵[i,startCol,j,k]为对角坐标的子矩阵和>之前的最大值
                    // 说明找到新的最大子矩阵的和,可以更新res了
                    // 归根到底就是在遍历所有以sum[k]结尾的情形找到最大值并保存其最大值坐标到res里
                    // 参考"最大连续子数组的和"的状态压缩写法就懂了
                    if (dp > max) {
                        // 更新最大子矩阵和
                        max = dp;
                        // 更新res的对角坐标
                        res[0] = i; // 起始行
                        res[1] = startCol; // 上次另起炉灶的起始列
                        res[2] = j; // 结束行
                        res[3] = k; // 当前刚好加上的第k列
                    }
                    // 若碰到dp<0表明当前sum[startCol,k]的和将会对后面的起拖累作用
                    // 因此以k+1为结尾sum[k+1]的不能前面段合并
                    if (dp < 0) {
                        // 后面sum[k+1]结尾的，连续子序列和要另起炉灶
                        dp = 0;
                        // 更新列的起始坐标(不被前面的拖累因此为k+1)
                        startCol = k + 1;
                    }
                }
            }
        }
        System.out.println(max);
        return res;
    }
}