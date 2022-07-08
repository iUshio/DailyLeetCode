package dailyPromblem;

public class s206 {

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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s1 = head.next, s2 = s1;
        head.next = null;
        while (s1 != null) {
            s2 = s2.next;

            s1.next = head;
            head = s1;
            s1 = s2;
        }
        return head;
    }
}
