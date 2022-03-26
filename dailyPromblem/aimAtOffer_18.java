package dailyPromblem;

public class aimAtOffer_18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode point = head.next;
        ListNode pre = head;
        // 如果删除头结点
        if(head.val == val){
            head = head.next;
            return head;
        }

        while(point != null){
            if(point.val ==  val){
                pre.next = point.next;
                break;
            }
            point = point.next;
            pre = pre.next;
        }

        return head;
    }
}
