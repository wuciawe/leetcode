package InsertionSortList;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while(cur != null){
            pre.next = cur.next;
            ListNode p = dummy;
            while(p.next != pre.next){
                if(cur.val < p.next.val){
                    cur.next = p.next;
                    p.next = cur;
                    break;
                }
                p = p.next;
            }
            if(p.next == pre.next){
                pre.next = cur;
                pre = cur;
            }
            cur = pre.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-84,142,41,-17,-71,170,186,183,-21,-76,76,10,29,81,112,-39,-6,-43,58,41,111,33,69,97,-38,82,-44,-7,99,135,42,150,149,-21,-30,164,153,92,180,-61,99,-81,147,109,34,98,14,178,105,5,43,46,40,-37,23,16,123,-53,34,192,-73,94,39,96,115,88,-31,-96,106,131,64,189,-91,-34,-56,-22,105,104,22,-31,-43,90,96,65,-85,184,85,90,118,152,-31,161,22,104,-85,160,120,-31,144,115};
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i = 0; i < data.length; ++i){
            cur.next = new ListNode(data[i]);
            cur = cur.next;
        }
        Solution sol = new Solution();
        sol.insertionSortList(dummy.next);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}