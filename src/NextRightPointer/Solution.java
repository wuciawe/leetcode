package NextRightPointer;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root != null && root.left != null){
            TreeLinkNode ml = root.left;
            root.left.next = root.right;
            TreeLinkNode cur = root.right;
            TreeLinkNode upc = root;
            while(upc.next != null){
                upc = upc.next;
                cur.next = upc.left;
                upc.left.next = upc.right;
                cur = upc.right;
            }
            connect(ml);
        }
    }
}

class TreeLinkNode {
         int val;
         TreeLinkNode left, right, next;
         TreeLinkNode(int x) { val = x; }
     }