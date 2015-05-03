package ConstructBinaryTreePreorderInorderTraversal;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        else return build(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int pr, int[] inorder, int in, int len){
        if(len == 1){
            return new TreeNode(preorder[pr]);
        }
        int rvl = preorder[pr];
        int i = 0;
        for(; i < len; ++i){
            if(inorder[i + in] == rvl) break;
        }
        TreeNode root = new TreeNode(rvl);
        int llen = i;
        if(llen > 0)
            root.left = build(preorder, pr + 1, inorder, in, llen);
        int rlen = len - i - 1;
        if(rlen > 0)
            root.right = build(preorder, pr + i + 1, inorder, in + i + 1, rlen);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}