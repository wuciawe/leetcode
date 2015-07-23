package PalindromeLinkedList;

/**
 * Created by haha on 2015/7/23.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode faster = dummyHead;
        ListNode slower = dummyHead;

        boolean res = true;

        while(faster.next != null){
            if(faster.next.next != null){
                faster = faster.next.next;
                slower = slower.next;
            }else{
                break;
            }
        }

        if(faster == slower) return true;

        if(faster.next == null) faster = slower.next;
        else faster = slower.next.next;

        // reverse the list
        ListNode last = dummyHead;
        ListNode cur = dummyHead.next;
        while(cur != slower){
            ListNode tmp = cur.next;
            cur.next = last;
            last = cur;
            cur = tmp;
        }
        cur.next = last;

        last = slower.next;
        while(faster != null){
            if(faster.val != slower.val) res = false;
            faster = faster.next;
            ListNode tmp = slower.next;
            slower.next = last;
            last = slower;
            slower = tmp;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}