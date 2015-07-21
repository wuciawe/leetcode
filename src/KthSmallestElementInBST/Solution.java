package KthSmallestElementInBST;

/**
 * Created by haha on 2015/7/21.
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) return kthSmallest(root.right, k-1-count);
        else return root.val;
    }

    int countNodes(TreeNode n) {
        if (n == null) return 0;
        else return 1 + countNodes(n.left) + countNodes(n.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}