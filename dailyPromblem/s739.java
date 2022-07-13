package dailyPromblem;

import java.util.Stack;

public class s739 {
    public int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        if (len == 1) {
            return res;
        }
        // 栈中存放的元素从下到上依次递减
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int tmp = temperatures[i];
            // 栈中记录上一个元素
            // 如果当前的元素大于栈顶的元素，则更新res
            // 如果当前元素小于栈顶，不更新res，栈中记录未统计的元素
            while (!stack.isEmpty() && tmp > temperatures[stack.peek()]) {
                // 弹出栈顶
                int num = stack.pop();
                res[num] = i - num;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
    
        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
    
        return result;
    }
    
}
