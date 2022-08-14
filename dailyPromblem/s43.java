package dailyPromblem;

public class s43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String res = "0";
        int len1 = num1.length(), len2 = num2.length();

        for (int i = len1 - 1; i >= 0; i--) {
            int nums1 = num1.charAt(i) - '0';
            StringBuilder tmp = new StringBuilder();
            // 补0
            for (int j = len1 - 1; j > i; j--) {
                tmp.append(0);
            }
            int add = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int nums2 = num2.charAt(j) - '0';
                int sum = nums1 * nums2 + add;
                tmp.append(sum % 10);
                add = sum / 10;
            }
            if (add != 0) {
                tmp.append(add + "");
            }

            res = addSum(res, tmp.reverse().toString());
        }

        return res;
    }

    private String addSum(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1, add = 0;
        StringBuilder tmp = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int nums1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int nums2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;

            int sum = nums1 + nums2 + add;
            tmp.append(sum % 10);
            add = sum / 10;

            len1--;
            len2--;
        }

        return tmp.reverse().toString();
    }
}
