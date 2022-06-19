package dailyPromblem;

import java.util.*;

public class s856 {
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }

        char[] chars = s.toCharArray();
        // ( 则压入-1
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (char a : chars) {
            if (a == '(') {
                // 如果该位置为(，则压入
                stack.push(-1);
            } else {
                // 压入)，寻找上一个(
                int tmp = 0;
                while (!stack.isEmpty() && stack.peek() != -1) {
                    tmp += stack.pop();
                }

                stack.pop();
                if (tmp == 0) {
                    // 中间没有数字
                    stack.push(1);
                } else {
                    stack.push(tmp * 2);
                }

            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
