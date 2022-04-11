package dailyPromblem;

public class s1442 {

    public static void main(String[] args) {
        int[] test = { 1, 1 };
        System.out.println(countTriplets1(test));
    }

    // 三重循环法（最笨最简单）
    public static int countTriplets1(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int k = arr.length - 1;
        int j;
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = arr.length - 1;
            while (k > i) {
                j = k;
                while (j > i) {
                    // 计算a
                    int a = 0;
                    for (int x = i; x < j; x++) {
                        a = a ^ arr[x];
                    }
                    // 计算b
                    int b = 0;
                    for (int x = j; x <= k; x++) {
                        b = b ^ arr[x];
                    }
                    if (a == b) {
                        res++;
                        System.out.println("" + i + "" + j + "" + k);
                    }
                    j--;
                }
                k--;
            }

        }

        return res;
    }

    // 双重循环
    //S(i) = S(k+1) 所以只用关注i与k的取值（需要公式推导）
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (s[i] == s[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
