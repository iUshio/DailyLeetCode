package dailyPromblem;

public class s69 {

    // 暴力解法
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }

        int res = 1;
        while(res * res <= x && res * res > 0){
            res++;
        }
        return res - 1;
    }

    // 运用自然数e换底
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
