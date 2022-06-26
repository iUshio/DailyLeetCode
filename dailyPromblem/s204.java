package dailyPromblem;

import java.util.*;;

public class s204 {
    // 方法1：枚举法（超时）
    public int countPrimes1(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    // 方法2：埃氏筛，核心思想：
    // 如果 xx 是质数，那么大于 xx 的 xx 的倍数 2x,3x,\ldots2x,3x,… 
    // 一定不是质数，因此我们可以从这里入手。
    // 当然这里还可以继续优化，对于一个质数 xx，如果按上文说的我们从 2x2x 开始标记其实是冗余的，
    // 应该直接从 x\cdot xx⋅x 开始标记，因为 2x,3x,\ldots2x,3x,… 
    // 这些数一定在 xx 之前就被其他数的倍数标记过了，例如 22 的所有倍数，33 的所有倍数等。
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
