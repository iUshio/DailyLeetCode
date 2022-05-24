package dailyPromblem;

public class s546 {
    /*
     * 补充题目：一次可以移除具有相同颜色的连续盒子，是每次只能移除一个滑窗，而不是一次移除同一种颜色所有地方
     * 设dp[l][r][k]
     * 起始下标l(以0开始)，结束下标r，k表示在下标r后面紧接着有k个元素值和boxes[r]相同，的最大积分和
     * 比如[l,l+1,···,r-1,r,值同r，值同r，值同r]
     * 这里有3个元素和boxes[r]相同，即k==3，那么dp[l][r][3]=dp[l][r-1][0]+4*4
     * 因为有3个和[r]相同，即可以消除4个所以加上4*4
     ** 得到初始化条件dp[l][r][k]=dp[l][r-1][0]+(k+1)*(k+1)
     * 但是有可能在boxes[l]~boxes[r-1]中也存在和boxes[r]相同值的元素，有可能获得更大的积分和
     * 比如[l,l+1,···,i,···,r-1,r,值同r，值同r，值同r]，假设boxes[i]==boxes[r]
     * 那么可能先移除boxes[i+1]~boxes[r-1]，这样就能使原来的dp[l][r][3]的k=3变的更大，但是r变得更小，但是积分和更大
     * 因此就需要在boxes[l]~boxes[r-1]中找到boxes[i]==boxes[r]
     ** 这样子先移除boxes[i+1]~boxes[r-1]，这一部分的最大积分和是dp[i+1][r-1][0]
     * 移除之后是[l,l+1,···,i,值同i(原来是r)，值同i(原来是r+1)，值同i(原来是r+2)，值同i(原来是r+3)]
     * 剩下这部分是dp[l][i][k+1]
     ** 总和起来就是dp[l][r][k]=max(dp[l][r][k],dp[i+1][r-1][0]+dp[l][i][k+1])
     * 最后的答案就是dp[0][boxes.size()-1][0]
     */

    // 如何设计我们的子问题：消消乐中的决策就是，对于某一个连续区间 (1) 直接消除该子区间 (2)（再构造）多连一块再消除.
    // 其中"多连"一块又具有多个选择（同时需要记录，“多连了几块”，这是子问题的第三个维度）。
    int[][][] dp; // 这个是正常的搜索空间，但是我们不会用满，因为 k^2 + m^2 < (k+m)^2

    public int removeBoxes(int[] boxes) {
        int length = boxes.length;
        dp = new int[length][length][length];
        return calculatePoints(boxes, 0, length - 1, 0);
    }

    public int calculatePoints(int[] boxes, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] == 0) {
            int r1 = r, k1 = k;
            // 这里其实是在做剪枝，消除连续区间即可，不用递减尝试
            while (r1 > l && boxes[r1] == boxes[r1 - 1]) {
                r1--;
                k1++;
            }
            // (1)直接消除（连续区间是：从r开始的k+1块，其实就是消消乐中，我们点了一下第r块）
            dp[l][r][k] = calculatePoints(boxes, l, r1 - 1, 0) + (k1 + 1) * (k1 + 1);
            for (int i = l; i < r1; i++) {
                if (boxes[i] == boxes[r1]) {
                    // (2) 尝试多连一块再删；此时我们要消除阻碍相连的子区间，和前面分出来的另一个区间（对于它，后续相邻块增加了1）
                    // 此处不用担心i到r1中间有j与r1的值相等未被算入连续的乘积和中，第一个while循环解决即k1
                    dp[l][r][k] = Math.max(dp[l][r][k],
                            calculatePoints(boxes, l, i, k1 + 1) + calculatePoints(boxes, i + 1, r1 - 1, 0));
                }
            }
        }
        return dp[l][r][k];
    }
}
