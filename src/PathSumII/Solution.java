package PathSumII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null)
            solver(result, new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void solver(List<List<Integer>> result, List<Integer> cur, TreeNode node, int sum){
        if(node.left == null && node.right == null){
            if(sum - node.val == 0){
                cur.add(node.val);
                result.add(cur);
            }
        }else{
            if(node.left != null){
                List<Integer> l = new ArrayList<Integer>(cur);
                l.add(node.val);
                solver(result, l, node.left, sum - node.val);
            }
            if(node.right != null){
                List<Integer> l = new ArrayList<Integer>(cur);
                l.add(node.val);
                solver(result, l, node.right, sum - node.val);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
