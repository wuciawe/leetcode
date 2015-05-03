package ConstructBinaryTreeInorderPostorderTraversal;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        else return build(inorder, 0, postorder, 0, postorder.length);
    }

    private TreeNode build(int[] inorder, int in, int[] postorder, int po, int len){
        if(len == 1){
            return new TreeNode(postorder[po]);
        }
        int rvl = postorder[po + len - 1];
        int i = 0;
        for(; i < len; ++i){
            if(inorder[i + in] == rvl) break;
        }
        TreeNode root = new TreeNode(rvl);
        int llen = i;
        if(llen > 0)
            root.left = build(inorder, in, postorder, po, llen);
        int rlen = len - i - 1;
        if(rlen > 0)
            root.right = build(inorder, in + i + 1, postorder, po + i, rlen);
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.buildTree(new int[]{1,2,3,4}, new int[]{4,3,2,1});
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}