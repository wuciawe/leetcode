package CopyListRandomPointer;

import java.util.HashMap;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        for(RandomListNode node: map.keySet()){
            RandomListNode n = map.get(node);
            n.next = node.next == null ? null : map.get(node.next);
            n.random = node.random == null ? null : map.get(node.random);
        }
        return map.get(head);
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}