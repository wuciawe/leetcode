package ConvertSA2BST;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) return null;
        return build(num, num.length, 0);
    }

    private TreeNode build(int[] num, int len, int cur){
        if(len == 1){
            return new TreeNode(num[cur]);
        }
        int half = len / 2;
        TreeNode left = build(num, half, cur);
        cur += half;
        TreeNode root = new TreeNode(num[cur]);
        root.left = left;
        if(len - half - 1 > 0){
            root.right = build(num, len - half - 1, ++cur);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}