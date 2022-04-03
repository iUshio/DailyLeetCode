package dailyPromblem;

/**
 * interview02_05
 */
public class interview02_05 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        // 将l2转加到l1上
        ListNode l1tmp = l1;
        ListNode l2tmp = l2;
        while (l2tmp != null) {
            // 如果l1比l2短
            if (l1tmp.next == null) {
                l1tmp.val += l2tmp.val;
                l1tmp.next = l2tmp.next;
                break;
            }
            l1tmp.val += l2tmp.val;


            l1tmp = l1tmp.next;
            l2tmp = l2tmp.next;
        }
        
        l1tmp = l1;
        // l2tmp = l1tmp;

        while(l1tmp != null){
            l2tmp = l1tmp.next;
            if(l1tmp.val >= 10){
                // 如果发生进位
                // 当l1tmp是最后一位，即无后续结点时
                if(l2tmp == null){
                    l1tmp.val -= 10;
                    l1tmp.next = new ListNode(1);
                    break;
                }else{
                    l1tmp.val -= 10;
                    l2tmp.val += 1;
                }
            }
            l1tmp = l1tmp.next;
        }
        

        return l1;
    }
}