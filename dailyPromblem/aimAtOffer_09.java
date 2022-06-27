package dailyPromblem;

import java.util.*;

public class aimAtOffer_09 {
    class CQueue {

        private Stack<Integer> stack;
        private Stack<Integer> queue;

        public CQueue() {
            stack = new Stack<>();
            queue = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            // 队列中没有元素的情况
            if (queue.isEmpty() && stack.isEmpty()) {
                return -1;
            }
            // 弹出栈没有元素的情况
            if (queue.isEmpty()) {
                // 将stack中的元素倒入queue中
                while (!stack.isEmpty()) {
                    queue.push(stack.pop());
                }
            }
            return queue.pop();
        }
    }
}
