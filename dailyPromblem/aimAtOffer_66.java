package dailyPromblem;

public class aimAtOffer_66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return a;
        }
        // 计算所有元素之积
        int sum = 1, sum0 = 0;
        for (int item : a) {
            if (item == 0) {
                sum0++;
            } else {
                sum *= item;
            }
        }

        if (sum0 >= 2) {
            // 如果有两个0的话所有元素都为0
            for (int i = 0; i < len; i++) {
                a[i] = 0;
            }
        } else if (sum0 == 1) {
            // 如果只有一个0，除0以外所有元素都为0
            for (int i = 0; i < len; i++) {
                if (a[i] == 0) {
                    a[i] = sum;
                } else {
                    a[i] = 0;
                }

            }
        } else {
            // 没有0的情况
            for (int i = 0; i < len; i++) {
                a[i] = sum / a[i];
            }
        }

        return a;
    }
}
