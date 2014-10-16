package jswang.BTInorder;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JiashuoWang on 10/16/14.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new LinkedList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();

        if (root == null) return rs;
        else st.push(root);
        while (!st.isEmpty()) {
            TreeNode tmp = st.pop();
            if (tmp.left == null) rs.add(tmp.val);
            if (tmp.right != null) st.push(tmp.right);
            if (tmp.left != null) {
                TreeNode tmpp = tmp.left;
                tmp.left = null;
                tmp.right = null;
                st.push(tmp);
                st.push(tmpp);
            }
        }

        return rs;
    }
}
