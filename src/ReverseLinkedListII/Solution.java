package ReverseLinkedListII;

/**
 * Created by haha on 2015/4/30.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode pm = preM;
        ListNode newHead = preM;
        ListNode next = preM;

        int cnt = 0;
        while(next != null){
            if(++cnt == m){
                preM = next;
                next = next.next;
                pm = next;
                newHead = pm;
                break;
            }
            next = next.next;
        }
        preM.next = pm.next;
        while(cnt < n && preM.next != null){
            next = preM.next;
            preM.next = next.next;
            next.next = newHead;
            newHead = next;
            ++cnt;
        }

        pm.next = preM.next;
        preM.next = newHead;

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        sol.reverseBetween(head, 5, 5);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}