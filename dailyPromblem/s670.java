package dailyPromblem;

import java.util.*;

public class s670 {

    public static void main(String[] args) {
        System.out.println(maximumSwap(1939));
    }

    public static int maximumSwap(int num) {
        if (num >= 0 && num <= 11)
            return num;

        String tmp = "" + num;
        int[] arrays = new int[tmp.length()];
        char[] temp = tmp.toCharArray();
        for (int i = 0; i < tmp.length(); i++) {
            arrays[i] = Integer.parseInt("" + tmp.charAt(i));
        }

        // 对数组进行排序
        Arrays.sort(arrays);
        // 对数组与数字串比对，第一个不同的进行交换
        for (int i = 0; i < tmp.length(); i++) {
            if (arrays[tmp.length() - 1 - i] > Integer.parseInt("" + temp[i])) {
                // 被交换的大数字
                int k = arrays[tmp.length() - 1 - i];
                // 被交换的小数字
                int min = Integer.parseInt("" + temp[i]);
                // 替换小数字
                temp[i] = (char) (k + '0');
                i++;
                // 查找大数字（反方向找）
                i =tmp.length() - 1;
                while (i >=0 && temp[i] != (char) (k + '0')) {
                    i--;
                }
                temp[i] = (char) (min + '0');
                break;
            }
        }
        return Integer.parseInt(String.valueOf(temp));

    }
}
