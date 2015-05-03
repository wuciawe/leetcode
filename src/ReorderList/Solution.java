package ReorderList;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode faster = head;
        ListNode slower = head;
        while(faster != null && faster.next != null){
            faster = faster.next.next;
            if(faster != null){
                slower = slower.next;
            }
        }
        ListNode tmp = slower.next;
        slower.next = null;
        slower = tmp;
        faster = reverse(slower);
        slower = head;
        while(faster != null){
            tmp = faster.next;
            faster.next = slower.next;
            slower.next = faster;
            faster = tmp;
            slower = slower.next.next;
        }
    }

    private ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode tmp;
        while(next != null){
            tmp = head;
            head = next;
            next = next.next;
            head.next = tmp;
        }
        return head;
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