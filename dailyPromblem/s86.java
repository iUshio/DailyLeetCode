package dailyPromblem;

public class s86 {
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

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 寻找第一个大于等于x的节点,preNode指向它的前面一个指针
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val >= x) {
                break;
            }
            preNode = preNode.next;
            tmp = tmp.next;
        }
        if (tmp == null) {
            // 没有找到大于等于x的节点，直接返回
            return head;
        }

        // 从preNode往后进行遍历，即tmp的位置
        ListNode pre = preNode;
        while (tmp != null) {
            if (tmp.val < x) {
                // 将该节点移动到prNode后面，prNode向后移动一位
                pre.next = tmp.next;
                tmp.next = preNode.next;
                if (preNode.next == head) {
                    // 移动头指针
                    head = tmp;
                }
                preNode.next = tmp;
                preNode = preNode.next;
                tmp = pre.next;
            } else {
                tmp = tmp.next;
                pre = pre.next;
            }

        }
        return head;
    }
}
