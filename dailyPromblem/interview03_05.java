package dailyPromblem;

import java.util.*;

public class interview03_05 {
    class SortedStack {
        Stack<Integer> stack;
        Stack<Integer> helpStack;
        public SortedStack() {
            stack = new Stack<>();
            helpStack = new Stack<>();
        }
    
        public void push(int val) {
            if (stack.empty()) {
                // 如果stack是空的则不用考虑大小问题，直接压入
                stack.push(val);
            } else if (stack.peek() < val) {
                // 如果stack头部的数比val小
                // val应该放到stack的底部，所以先把stack的所有数据先放到helpstack中
                while (!stack.empty() && stack.peek() < val) {
                    helpStack.push(stack.pop());
                }
                stack.push(val);
            } else if (helpStack.empty() || helpStack.peek() <= val) {
                // val小于stack顶部但比helpstack顶部的值大
                // 这种情况也可以放到stack顶部
                helpStack.push(val);
            }else{
                // val小于stack顶部且比helpstack顶部的值小
                // 此时得先把helpstack中比val大的值先放回stack
                while (!helpStack.empty() && helpStack.peek() > val) {
                    stack.push(helpStack.pop());
                }
                helpStack.push(val);
            }
        }
    
        public void pop() {
            while (!helpStack.empty()) {
                stack.push(helpStack.pop());
            }
            if (!isEmpty()) {
                stack.pop();
            }
    
        }
    
        public int peek() {
            while (!helpStack.empty()) {
                stack.push(helpStack.pop());
            }
            if (isEmpty()) {
                return -1;
            }
            return stack.peek();
        }
    
        public boolean isEmpty() {
            return stack.empty();
        }
    }
}
