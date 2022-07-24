package dailyPromblem;

import java.util.*;;

public class s3 {

    public static void main(String[] args) {
        String s = "   ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        if (len < 2) {
            return len;
        }

        char[] str = s.toCharArray();
        // 记录字母出现的最远位置
        int[] words = new int[128];
        Arrays.fill(words, -1);
        int res = 0, tmp = 0;
        for (int i = 0; i < len; i++) {
            // 判断本字母是否重复
            if(words[str[i] - ' '] == -1 || words[str[i] - ' '] < tmp){
                // 未出现重复
                words[str[i] - ' '] = i;
            }else{
                tmp = words[str[i] - ' '] + 1;
                words[str[i] - ' '] = i;
            }
            res = Math.max(res, i - tmp + 1);
        }
        return res;
    }
}
