package jswang.LowestCommonAncestor;

/**
 * Created by willwjs on 2/25/15.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.val == n1 || root.val == n2)
            return root;
        TreeNode left_lca = findLCA(root.left, n1, n2);
        TreeNode right_lca = findLCA(root.right, n1, n2);
        if (left_lca != null && right_lca != null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftleft = new TreeNode(4);
        TreeNode leftright = new TreeNode(5);
        left.left = leftleft;
        left.right = leftright;

        Solution sol = new Solution();
        System.out.println(sol.findLCA(root, 4, 3).val);
    }
}
