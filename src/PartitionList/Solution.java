package PartitionList;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode tmp;

        while(cur.next != null){
            if(cur.next.val >= x){
                cur = cur.next;
            }else{
                if(pre != cur){
                    tmp = pre.next;
                    pre.next = cur.next;
                    pre = pre.next;
                    cur.next = pre.next;
                    pre.next = tmp;
                }else{
                    pre = pre.next;
                    cur = pre;
                }
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