package com.example;


/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return result;
    }

    private boolean traverse(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null || result != null) {
            return false;
        }

        int left = traverse(node.left, p, q) ? 1 : 0;
        int right = traverse(node.right, p, q) ? 1 : 0;

        int val = node.equals(p) || node.equals(q) ? 1 : 0;

        if (left + right + val > 1)
            result = node;

        return left + right + val > 0;

    }


}


