package dailyPromblem;

public class sa25 {
    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2));
        
        System.out.println(reverseKGroup(head, 2).val);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head.next == null) {
            return head;
        }

        ListNode preOrder = new ListNode();
        preOrder.next = head;

        // h1，h2包裹需要翻转的节点（不包含h1，h2）
        ListNode h1 = preOrder, h2 = head;
        ListNode pre, tail;
        while (h1.next != null) {
            // h2指针向后移动k次
            for (int i = 0; i < k; i++) {
                h2 = h2.next;
                // 节点总数不是 k 的整数倍，结束翻转
                if (h2 == null && i != k - 1) {
                    return preOrder.next;
                }
            }
            pre = h1.next;
            tail = h1.next;
            // 翻转h1，h2中的节点
            ListNode tmp = tail.next;
            while (tmp != h2) {
                tail.next = tmp.next;
                h1.next = tmp;
                tmp.next = pre;

                pre = tmp;
                tmp = tail.next;
            }

            // 移动h1，h2指针
            h1 = tail;
            h2 = h1.next;
        }

        return preOrder.next;
    }
}
