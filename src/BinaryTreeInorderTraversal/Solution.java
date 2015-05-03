package BinaryTreeInorderTraversal;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haha on 2015/4/29.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Element> stack = new Stack<Element>();
        if(root != null)
            stack.push(new Element(root));
        while(!stack.isEmpty()){
            Element ele = stack.pop();
            if(ele.ready){
                result.add(ele.node.val);
            }else{
                if(ele.node.right != null) stack.push(new Element(ele.node.right));
                ele.ready = true;
                stack.push(ele);
                if(ele.node.left != null) stack.push(new Element(ele.node.left));
            }
        }
        return result;
    }
}

class Element {
    TreeNode node;
    boolean ready;
    Element(TreeNode n){
        node = n;
        ready = false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}