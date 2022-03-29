package dailyPromblem;

import java.util.List;

public class s143 {
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
        ListNode x1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));

        reorderList2(x1);
    }

    public static void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return;

        ListNode pre = head;//头指针
        ListNode point = head;//寻找最后一个节点的指针
        ListNode tmp;//交换节点用的临时指针
        ListNode x;
        while(pre.next != null && pre.next.next != null){
            // 寻找最后一个节点
            while(point.next.next != null){
                point = point.next;
            }
            x = point;
            point = point.next;
            x.next = null;
            // 将最后一个节点移送到pre之后
            tmp = pre.next;
            pre.next = point;
            point.next = tmp;

            // pre指针移动
            pre = tmp;
            point = pre;
        }

    }

    public static void reorderList2(ListNode head) {
        if(head.next == null || head.next.next == null) return;

        int len = 0;//记录链表长度
        ListNode tmp = head;
        
        while(tmp != null){
            len++;
            tmp = tmp.next;
        }
        tmp = head;

        for(int i = 0;i < len/2;i++){
            tmp = tmp.next;
        }
        // 此时tmp记录第一个要替换到前面的节点

        ListNode pre = head;
        ListNode point = tmp;
        ListNode tempt;

        if(point.next == null){//三个节点的情况
            tempt = pre.next;
            tempt.next = null;
            pre.next = point;
            point.next = tempt;
            return;
        }

        while(tmp.next != null){
            // 寻找到最后一个指针
            while(point.next.next != null){
                point = point.next;
            }
            tempt = point;
            point = point.next;
            tempt.next = null;

            // 移动节点
            ListNode x = pre.next;
            pre.next = point;
            point.next = x;

            pre = x;
            point = tmp;
        }

    }

    public void reorderList3(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}
