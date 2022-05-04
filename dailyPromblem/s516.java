package dailyPromblem;


public class s516 {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 1){
            return 1;
        }

        String s1 = reverse(s);
        int[][] dp = new int[len + 1][len + 1];
        for(int i = 1; i < len + 1; i++){
            for(int j = 1; j < len + 1; j++){
                if(s1.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[len][len];
    }

    public String reverse(String s){
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

    // 思路同上面方法一样，只不过是一个正序搜索，一个倒叙搜索
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
