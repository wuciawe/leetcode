package PopulatingNextRightPointersInEachNodeII;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        while(root != null){
            TreeLinkNode cur = dummy;
            while(root != null){
                if(root.left != null){
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null){
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = dummy.next;
            dummy.next = null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        sol.connect(root);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}