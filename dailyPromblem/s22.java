package dailyPromblem;

import java.util.*;

/**
 * s22
 */
public class s22 {

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode x2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode x3 = new ListNode(2,new ListNode(6));
        ListNode[] tmp = {x1,x2,x3};
        ListNode temp = mergeKLists(tmp);
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        List<ListNode> nums = new ArrayList<>();

        for (ListNode tmp : lists) {
            while (tmp != null) {
                nums.add(tmp);
                tmp = tmp.next;
            }
        }
        if(nums.size() == 0){
            return null;
        }
        
        Collections.sort(nums, new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
            
        });

        ListNode res = nums.get(0);
        ListNode tmp = res;
        for (ListNode x : nums) {
            tmp.next = x;
            tmp = tmp.next;
        }
        tmp.next = null;

        return res;
    }
}