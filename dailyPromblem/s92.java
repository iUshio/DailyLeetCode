package dailyPromblem;

public class s92 {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode preHead = new ListNode();
        preHead.next = head;
        // 寻找Left节点的上一个位置
        ListNode lNode = preHead;
        for (int i = 0; i < left - 1; i++) {
            lNode = lNode.next;
        }
        // 从left节点开始寻找right节点
        ListNode rNode = lNode.next;
        for (int i = 0; i < right - left; i++) {
            rNode = rNode.next;
        }

        // 反转链表
        head = lNode.next;
        ListNode tail = head;
        ListNode s1 = tail.next;
        
        while (lNode.next != rNode) {
            // 将s1位置的节点交换到lNode的后面也即要交换位置的首位
            lNode.next = s1;
            tail.next = s1.next;
            s1.next = head;

            // 转移节点
            head = s1;
            s1 = tail.next;
        }

        return preHead.next;
    }
}
