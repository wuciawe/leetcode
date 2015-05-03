package RecoverBST;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, pre = root;
        while(pre.left != null){
            pre = pre.left;
        }
        while(root != null){
            if(root.left != null){
                TreeNode cur = root.left;
                while(cur.right != null && cur.right != root){
                    cur = cur.right;
                }
                if(cur.right == null){
                    cur.right = root;
                    root = root.left;
                    continue;
                }else{
                    cur.right = null;
                }
            }

            if(root.val < pre.val){
                if(first == null){
                    first = pre;
                }
                second = root;
            }

            pre = root;
            root = root.right;
        }

        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}