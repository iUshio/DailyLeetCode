package dailyPromblem;

public class s557 {

    public static void main(String[] args) {
        reverseWords("i am ushio");
    }

    public static String reverseWords(String s) {
        if(s.length() == 1){
            return s;
        }
        String[] tmp = s.split("\\ ");
        String res = new String();
        for(String a:tmp){
            res += new StringBuilder(a).reverse().toString();
            res += "" + ' ';
        }
        res = res.substring(0,res.length() - 1);
        return res;
    }
}
