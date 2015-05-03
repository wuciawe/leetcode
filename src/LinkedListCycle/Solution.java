package LinkedListCycle;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;

        while(faster != null){
            faster = faster.next;
            if(faster != null){
                faster = faster.next;
            }else{
                return false;
            }
            slower = slower.next;
            if(faster == slower) return true;
        }
        return false;
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