package UniqueBSTII;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    private HashMap<Integer, List<TreeNode>> cache = new HashMap<Integer, List<TreeNode>>();

    public List<TreeNode> generateTrees(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        List<TreeNode> l = new ArrayList<TreeNode>();
        if(n == 1){
            l.add(new TreeNode(1));
        }else if(n > 0){
            for(TreeNode rnode: generateTrees(n - 1)){
                TreeNode ml = new TreeNode(1);
                ml.right = shift(rnode, 1);
                l.add(ml);
            }
            for(int i = 2; i < n; ++i){
                List<TreeNode> lefts = generateTrees(i - 1);
                List<TreeNode> rights = new ArrayList<TreeNode>();
                for(TreeNode node: generateTrees(n - i)){
                    rights.add(shift(node, i));
                }
                for(TreeNode left: lefts){
                    for(TreeNode right: rights){
                        TreeNode mid = new TreeNode(i);
                        mid.left = left;
                        mid.right = right;
                        l.add(mid);
                    }
                }
            }
            for(TreeNode lnode: cache.get(n - 1)){
                TreeNode mr = new TreeNode(n);
                mr.left = lnode;
                l.add(mr);
            }
        }else{
            l.add(null);
        }
        cache.put(n, l);
        return l;
    }

    private TreeNode shift(TreeNode node, int shift){
        if(node == null) return null;
        TreeNode root = new TreeNode(node.val + shift);
        root.left = shift(node.left, shift);
        root.right = shift(node.right, shift);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}
