package dailyPromblem;

public class s2 {
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
        // 以l2为基准，返回l2
        ListNode l1Tmp = l1;
        ListNode l2Tmp = l2;
        int tmp = 0;
        int left = 0;
        while (l2Tmp.next != null) {
            if (l1Tmp == null) {
                left = 0;
            } else {
                left = l1Tmp.val;
                l1Tmp = l1Tmp.next;
            }

            l2Tmp.val += left + tmp;
            tmp = 0;

            if (l2Tmp.val > 9) {
                tmp = 1;
                l2Tmp.val -= 10;
            }

            l2Tmp = l2Tmp.next;
        }

        if (l1Tmp != null) {
            l2Tmp.next = l1Tmp.next;
            l1Tmp.next = null;
        }

        // l1仅存一个节点或没有
        while (l2Tmp != null) {
            if (l1Tmp == null && tmp == 0) {
                break;
            } else if (l1Tmp == null && tmp == 1) {
                l2Tmp.val += 1;
                tmp = 0;
            } else {
                l2Tmp.val += tmp + l1Tmp.val;
                tmp = 0;
                l1Tmp = l1Tmp.next;
            }

            if (l2Tmp.val > 9) {
                tmp = 1;
                l2Tmp.val -= 10;
                if (l2Tmp.next == null) {
                    l2Tmp.next = new ListNode(1);
                    break;
                }
            }
            l2Tmp = l2Tmp.next;
        }

        return l2;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
