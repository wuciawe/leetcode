package RemoveDuplicatesSortedListII;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if(cur == null || cur.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        cur = cur.next;

        while(cur != null){
            if(pre.next.val == cur.val){
                cur = cur.next;
                while(cur != null && cur.val == pre.next.val){
                    cur = cur.next;
                }
                pre.next = cur;
                if(cur == null) break;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}