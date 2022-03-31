package dailyPromblem;

public class s83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int num = head.val;
        ListNode tmp = head;

        while ( tmp != null && tmp.next != null) {
            if (tmp.next.val == num) {
                tmp.next = tmp.next.next;
            } else {
                num = tmp.next.val;
                tmp = tmp.next;
            }
        }

        return head;
    }
}
