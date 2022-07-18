package dailyPromblem;

public class s5 {

    public static void main(String[] args) {
        String s = "babd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {

                if(j < i){
                    continue;
                }else if(i == j){
                    // 只有一个元素
                    dp[i][j] = true;
                    continue;
                }

                if (charArray[i] != charArray[j]) {
                    // 不相等的话该区间的字符串无法构成回文字符串
                    dp[i][j] = false;
                } else {

                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
