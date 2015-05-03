package ReverseNodesInKGroup;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(true){
            ListNode temp = head;
            int i = k;
            for(; i > 0 && temp != null; --i){
                temp = temp.next;
            }
            if(i != 0) break;
            i = k;

            ListNode oh = head;
            for(; i > 0; --i){
                ListNode t = head.next;
                head.next = cur.next;
                cur.next = head;
                head = t;
            }
            cur = oh;

            head = temp;
        }
        cur.next = head;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        sol.reverseKGroup(head, 5);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}