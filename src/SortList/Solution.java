package SortList;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode l, ListNode r){
        if(l == r || l.next == r) return l;
        ListNode dummy = new ListNode(0);
        dummy.next = l;
        ListNode faster = l;
        ListNode slower = l;
        while(faster != r){
            faster = faster.next;
            slower = slower.next;
            if(faster != r) faster = faster.next;
        }
        l = sort(dummy.next, slower);
        r = sort(slower, faster);
        return merge(l, slower, r, faster);
    }

    private ListNode merge(ListNode ll, ListNode lr, ListNode rl, ListNode rr){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(ll != lr && rl != rr){
            if(rl.val <  ll.val){
                cur.next = rl;
                rl = rl.next;
            }else{
                cur.next = ll;
                ll = ll.next;
            }
            cur = cur.next;
        }
        if(ll != lr) {
            cur.next = ll;
            while(cur.next != lr){
                cur = cur.next;
            }
            cur.next = rr;
        }
        if(rl != null) cur.next = rl;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}