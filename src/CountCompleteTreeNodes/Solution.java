package CountCompleteTreeNodes;

import java.util.HashMap;

/**
 * Created by haha on 2015/6/13.
 */
public class Solution {
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    int height(TreeNode root) {
        if(memo.containsKey(root)) return memo.get(root);
        int res = root == null ? -1 : 1 + height(root.left);
        memo.put(root, res);
        return res;
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}