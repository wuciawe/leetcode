package ConvertSL2BST;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        int len = 0;
        while(cur.next != null){
            ++len;
            cur.next = cur.next.next;
        }
        if(len == 0) return null;

        cur.next = head;
        return build(cur, len);
    }

    private TreeNode build(ListNode cur, int len){
        if(len == 1){
            TreeNode node = new TreeNode(cur.next.val);
            cur.next = cur.next.next;
            return node;
        }
        int half = len / 2;
        TreeNode left = build(cur, half);
        TreeNode root = new TreeNode(cur.next.val);
        root.left = left;
        cur.next = cur.next.next;
        if(len - half - 1 > 0){
            root.right = build(cur, len - half - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] d = new int[]{0,1,2,3,4,5,6,7};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 0; i < d.length; ++i){
            head.next = new ListNode(d[i]);
            head = head.next;
        }
        sol.sortedListToBST(cur.next);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}