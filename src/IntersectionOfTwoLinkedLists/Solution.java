package IntersectionOfTwoLinkedLists;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = 0;
        int lenb = 0;
        ListNode ha = new ListNode(0);
        ha.next = headA;
        ListNode cura = ha;
        ListNode hb = new ListNode(0);
        hb.next = headB;
        ListNode curb = hb;

        while(cura.next != null){
            ++lena;
            cura = cura.next;
        }
        while(curb.next != null){
            ++lenb;
            curb = curb.next;
        }

        if(lena == 0 && lenb == 0 || cura != curb) return null;

        int diff = Math.abs(lena - lenb);

        ListNode shorter, longer;
        if(lena < lenb){
            shorter = ha;
            longer = hb;;
        }else{
            shorter = hb;
            longer = ha;
        }

        for(int i = diff; i > 0; --i){
            longer = longer.next;
        }

        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
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