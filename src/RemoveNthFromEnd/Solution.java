package RemoveNthFromEnd;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fore = head;
        while(n-- > 0)
            fore = fore.next;
        if(fore == null) return head.next;
        fore = fore.next;
        ListNode post = head;
        while(fore != null){
            fore = fore.next;
            post = post.next;
        }
        post.next = post.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}