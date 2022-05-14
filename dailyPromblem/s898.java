package dailyPromblem;

import java.util.*;

public class s898 {

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        System.out.println(subarrayBitwiseORs(arr));
    }

    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] | arr[j]) == arr[j]) {
                    // arr[j]的置位位置包含了arr[i]的置位位置，
                    // 那么已经无需考虑arr[i]的加入与否
                    break;
                }
                // 求值的同时保留积累状态
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }
        return set.size();
    }
}
