package dailyPromblem;

public class aimAtOffer_22 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // 双指针
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k - 1; i++) {
            if(right.next == null) return right;
            right = right.next;
        }
        
        while(right.next != null){
            right = right.next;
            left = left.next;
        }

        return left;
    }
}
