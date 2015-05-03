package LinkedListCycleII;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                p2 = head;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p2;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}