package dailyPromblem;

import java.util.*;

public class s394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        // 记录字符串出现的次数
        Stack<Integer> stackNum = new Stack<>();
        // 记录该区间之前取得的字符串
        Stack<String> stackStr = new Stack<>();
        int num = 0;
        for(Character c:s.toCharArray()){
            if(c >= '0' && c <= '9'){
                num = num * 10 + Integer.parseInt(c + "");
            }else if(c == '['){
                // 将已取得的字符串压入队列中
                stackStr.push(sb.toString());
                stackNum.push(num);
                // 重置num
                num = 0;
                sb = new StringBuilder();
            }else if(c == ']'){
                int tmpNum = stackNum.pop();
                StringBuilder tmp = new StringBuilder();
                for(int i =0; i < tmpNum; i++){
                    tmp.append(sb);
                }
                sb = new StringBuilder(stackStr.pop() + tmp);
                
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
