package dailyPromblem;

public class s1013 {

    public static void main(String[] args) {
        int[] arr = { 3,3,6,5,-2,2,5,1,-9,4 };
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        // 求arr的平均值并除以三求得每个部分的数值
        for (int a : arr) {
            sum += a;
        }
        // 如果sum不是3的整倍数，返回false
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        int point = 0;
        int[] sums = { 0, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for (int a : arr) {
            if (sums[point] == Integer.MIN_VALUE) {
                sums[point] = 0;
            }
            if (point == 2) {
                sums[point] += a;
            } else {
                sums[point] += a;
                if (sums[point] == sum) {
                    point++;
                }
            }

        }

        for(int a:sums){
            if(a != sum){
                return false;
            }
        }

        return true;
    }

    public boolean canThreePartsEqualSum1(int[] A) {
        int s = 0;
        for (int num : A) {
            s += num;
        }
        if (s % 3 != 0) {
            return false;
        }
        // 求出平均值
        int target = s / 3;
        int n = A.length, i = 0, cur = 0;
        // 切割出第一组
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            ++i;
        }
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        // 切割出第二组，第二组存在第三次则必合法
        while (j + 1 < n) {  // 需要满足最后一个数组非空
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            ++j;
        }
        return false;
    }
}
