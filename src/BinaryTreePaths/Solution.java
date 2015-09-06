package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by haha on 2015/9/6.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<String> ret = new ArrayList<>();
        String b = root.val + "->";
        ret.addAll(binaryTreePaths(root.left).stream().map(s -> b + s).collect(Collectors.toList()));
        ret.addAll(binaryTreePaths(root.right).stream().map(s -> b + s).collect(Collectors.toList()));
        if(ret.isEmpty()) ret.add(root.val + "");
        return ret;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}