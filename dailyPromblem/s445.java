package dailyPromblem;

import java.util.*;

public class s445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        Stack<ListNode> res = stack1.size() > stack2.size() ? stack1 : stack2;
        Stack<ListNode> lres = stack1.size() < stack2.size() ? stack2 : stack1;

        ListNode tmp = new ListNode();
        while (!res.isEmpty()) {
            tmp = res.pop();
            if (!lres.isEmpty()) {
                // 如果第二个数组空了，不再去进行加操作了
                tmp.val += lres.pop().val;
            }
            if (tmp.val > 9) {
                // 产生进位
                if (res.isEmpty()) {
                    // 最后一位发生进位,往栈里面再添加一位
                    res.push(new ListNode(1, tmp));
                    tmp.val -= 10;
                } else {
                    res.peek().val += 1;
                    tmp.val -= 10;
                }
            }
        }

        return tmp;
    }

    // 官方解法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            // 栈空了就弹出0
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();

            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
