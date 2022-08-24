package dailyPromblem;

public class s61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode pre = head, tail = head;
        int len = 0;
        while (pre != null) {
            len++;
            pre = pre.next;
        }

        pre = head;
        k = k % len;
        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }
        if (tail == null) {
            // k等于head长度的情况，不用移动
            return head;
        }
        // 移动指针
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }
        // 此时pre指针的下一个即pre.next应该为头指针，pre为尾指针
        tail.next = head;
        head = pre.next;
        pre.next = null;
        return head;

    }
}
