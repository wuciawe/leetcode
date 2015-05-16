package RemoveDupFromSortedList;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(next != null && next.val == cur.val){
                cur.next = next.next;
            }else{
                cur = cur.next;
            }
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