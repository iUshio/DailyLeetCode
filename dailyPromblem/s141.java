package dailyPromblem;

public class s141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head, slow = head;

        while (fast != null) {
            fast = fast.next;
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
