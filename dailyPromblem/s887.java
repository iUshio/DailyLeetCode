package dailyPromblem;

public class s887 {
    public static int superEggDrop(int k, int n) {
        // 操作数
        int T = 1;
        // 小于n + 1是因为地面0层也要算在内
        while (calcF(k, T) < n + 1) T++;
        return T;
    }
    
    // k个鸡蛋，t次操作能确定的楼层
    private static int calcF(int K, int T)
    {
        // 如果只剩下一个蛋或者只有一次操作机会至多能确定T + 1层
        // 如果只有1个蛋，那就从第一层慢慢网上扔，知道蛋碎
        if (T == 1 || K == 1) return T + 1;
        // 依次递归，分为蛋碎了或者不碎
        // 蛋如果碎了能确定上面的层无效，但如果没碎能确定下面的层无效加起来即能确定所有的层
        return calcF(K - 1, T - 1) + calcF(K, T - 1);
    }

    public static void main(String[] args) {
        System.out.println(calcF(1, 1));
    }
}
