package AddTwoNumbers;

/**
 * Created by haha on 2015/4/12.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        solve(result, 0, l1, l2);
        return result.next;
    }

    private void solve(ListNode cur, int c, ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            if(c != 0) cur.next = new ListNode(c);
            return;
        }
        int value = c;
        if(l1 != null){
            value += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            value += l2.val;
            l2 = l2.next;
        }
        cur.next = new ListNode(value % 10);
        cur = cur.next;
        solve(cur, value / 10, l1, l2);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Solution sol = new Solution();
        sol.addTwoNumbers(l1, l2);
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