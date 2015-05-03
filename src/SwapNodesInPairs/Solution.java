package SwapNodesInPairs;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head != null && head.next != null){
            cur.next = head.next;
            cur = cur.next;
            ListNode temp = cur.next;
            cur.next = head;
            cur = cur.next;
            head = temp;
        }
        cur.next = head;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        sol.swapPairs(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}