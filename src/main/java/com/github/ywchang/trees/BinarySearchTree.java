package com.github.ywchang.trees;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void add(int val) {
        this.root = this.addRecursive(this.root, val);
    }

    private TreeNode addRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = this.addRecursive(node.left, val);
        }
        if (val > node.val) {
            node.right = this.addRecursive(node.right, val);
        }
        return node;
    }

    public String toString() {
        return Trees.toString(this.root);
    }

    public TreeNode search(int val) {
        return this.searchRecursive(this.root, val);
    }

    private TreeNode searchRecursive(TreeNode node, int val) {
        if(node == null || node.val == val) {
            return node;
        }
        if(val < node.val) {
            return this.searchRecursive(node.left, val);
        }
        return this.searchRecursive(node.right, val);
    }
}
