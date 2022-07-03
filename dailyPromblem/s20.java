package dailyPromblem;

import java.util.*;

public class s20 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }

        char[] string = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        char tempt;
        for (char i : string) {
            // 遇到( ，[ ，{ 则压入，遇到截止符则弹出并判断
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                // 如果栈为空，则没有匹配符
                if (stack.empty())
                    return false;
                    
                tempt = stack.pop();
                switch (tempt) {
                    case '(': {
                        if (i != ')')
                            return false;
                        break;
                    }
                    case '[': {
                        if (i != ']')
                            return false;
                        break;
                    }
                    case '{': {
                        if (i != '}')
                            return false;
                        break;
                    }
                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
}
