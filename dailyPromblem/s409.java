package dailyPromblem;

public class s409 {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome2(s));
    }

    public int longestPalindrome(String s) {
        if(s.length() == 1){
            return 1;
        }

        int[] chaStr = new int[58];
        for(char str:s.toCharArray()){
            chaStr[str - 'A']++;
        }
        int res = 0;
        for(int num:chaStr){
            if(num == 0){
                continue;
            }else if(num % 2 == 0){
                res += num;
            }else{
                res += (num - 1);
            }
        }

        return res < s.length()? res + 1:res;
    }

    public static int longestPalindrome2(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[58];
        for(char c : s.toCharArray()) {
            arr[c - 'A']++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
