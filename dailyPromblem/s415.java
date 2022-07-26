package dailyPromblem;

public class s415 {
    public String addStrings1(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1,  p2 = num2.length() - 1,add = 0;
        while(p1 >= 0 || p2 >= 0 || add == 1){
            int nums1 = p1 >= 0? num1.charAt(p1) - '0':0;
             int nums2 = p2 >= 0? num2.charAt(p2) - '0':0;
             sb.append("" + (nums1 + nums2 + add) % 10);
             add =  (nums1 + nums2 + add) / 10;
             p1--;
             p2--;
        }

        return sb.reverse().toString();
    }
}
