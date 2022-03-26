package dailyPromblem;

public class interview01_06 {

    public static void main(String[] args) {
        System.out.println(compressString("rrrrLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLvvvvvvvvvvvKKKKKKKKKKKKKKiiiiiiiiiiiiiiiiiiiiiiiiiiiiZZZZZZZZZZZZZZZZZZZIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIoooooooooooooooooooooooooooooooooooobbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbvvvvvvvvvvvvvvvvvvvvvvvllllllllllllllllllllllllllllllllllllllllBBBBBBBKKKKKKKKKKKKKKfffffffffffffffffffffffffffffffffffDDDDDDDDDDDDDDDDDDDDDDDDDDDsssssssssssssssssssssssssssssssssssssssNNNNNZZZZZZZZZZZZZZZZZZZZZZZZZZNNNNNNNNNNDDDDDDDDDDDDDDDTTTTT"));
    }

    public static String compressString(String S) {
        if (S.length() == 0 || S.length() == 1) {
            return S;
        }
        StringBuilder tmp = new StringBuilder();
        char temp = S.charAt(0);
        int n = 0;

        for (int i = 0; i < S.length(); i++) {
            
            if (temp != S.charAt(i)) {
                tmp.append(temp).append(n);
                n = 1;
                temp = S.charAt(i);
            } else {
                n++;
            }
        }

        tmp.append(temp).append(n);
        if (tmp.length() >= S.length())
            return S;
        else
            return tmp.toString();
    }
}
