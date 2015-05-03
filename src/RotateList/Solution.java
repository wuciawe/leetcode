package RotateList;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode cur = dummy;
        while(cur.next != null){
            ++len;
            cur = cur.next;
        }
        if(len < 2) return head;
        k = k % len;
        if(k == 0) return head;

        ListNode faster = dummy;
        ListNode slower = dummy;

        while(k > 0){
            --k;
            faster = faster.next;
        }
        while(faster.next != null){
            faster = faster.next;
            slower = slower.next;
        }
        cur = slower.next;
        slower.next = null;
        faster.next = dummy.next;
        dummy.next = cur;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i = 0; i < data.length; ++i){
            cur.next = new ListNode(data[i]);
            cur = cur.next;
        }
        Solution sol = new Solution();
        dummy = sol.rotateRight(dummy.next, 1);
        cur = dummy;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}