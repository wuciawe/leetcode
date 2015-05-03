package MergeKSortedLists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/24.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int num = 0;
        HashSet<ListNode> ls = new HashSet<ListNode>();
        for(int i = 0; i < lists.length; ++i){
            ListNode l = lists[i];
            if(l != null){
                ++num;
                ListNode dummy = new ListNode(0);
                dummy.next = l;
                ls.add(dummy);
            }
        }
        while(num > 1){
            List<ListNode> cadidates = new ArrayList<ListNode>();
            int min = Integer.MAX_VALUE;

            for(ListNode l : ls){
                if(l.next.val < min){
                    cadidates.clear();
                    cadidates.add(l);
                    min = l.next.val;
                }else if(l.next.val == min){
                    cadidates.add(l);
                }
            }

            for(ListNode l : cadidates){
                ls.remove(l);
                cur.next = l.next;
                cur = cur.next;
                if(l.next.next != null){
                    l.next = l.next.next;
                    ls.add(l);
                }else{
                    --num;
                }
            }
        }
        if(num == 1) cur.next = ls.iterator().next().next;
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}