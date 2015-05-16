package ReverseLinkedList;

/**
 * Created by haha on 2015/5/15.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}