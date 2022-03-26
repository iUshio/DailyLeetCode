package dailyPromblem;

import java.util.*;

public class interview16_26 {

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        if (s == null)
            return 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                continue;
            }
            switch (s.charAt(i)) {
                case '+': {
                    // 找寻下一个数字直接入栈
                    while(i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                        i++;
                    }
                    int k = i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        i++;
                    }
                    if (i >= s.length()) {
                        stack.add(Integer.parseInt(s.substring(k)));
                    } else {
                        stack.add(Integer.parseInt(s.substring(k, i)));
                    }
                    i--;
                    break;
                }
                case '-': {
                    // 找寻下一个数字的负数入栈
                    while(i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                        i++;
                    }
                    int k = i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        i++;
                    }
                    if (i >= s.length()) {
                        stack.add(-1 * Integer.parseInt(s.substring(k)));
                    } else {
                        stack.add(-1 * Integer.parseInt(s.substring(k, i)));
                    }
                    i--;
                    break;
                }
                case '*': {
                    // 将stack.pop() * num入栈
                    while(i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                        i++;
                    }
                    int k = i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        i++;
                    }
                    if (i >= s.length()) {
                        stack.add(Integer.parseInt(s.substring(k)) * stack.pop());
                    } else {
                        stack.add(Integer.parseInt(s.substring(k, i)) * stack.pop());
                    }
                    i--;
                    break;
                }
                case '/': {
                    // 将stack.pop() / num入栈
                    while(i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                        i++;
                    }
                    int k = i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

                        i++;
                    }
                    if (i >= s.length()) {
                        stack.add(stack.pop() / Integer.parseInt(s.substring(k)));
                    } else {
                        stack.add(stack.pop() /Integer.parseInt(s.substring(k, i)));
                    }
                    i--;
                    break;
                }
                default: {
                    // 将当前数字直接入栈
                    int k = i;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        i++;
                    }
                    if (i >= s.length()) {
                        stack.add(Integer.parseInt(s.substring(k)));
                    } else {
                        stack.add(Integer.parseInt(s.substring(k, i)));
                    }
                    i--;
                    break;
                }
            }


        }

        //将stack中的数字相加
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
