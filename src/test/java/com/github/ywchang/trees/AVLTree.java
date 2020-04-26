package com.github.ywchang.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class AVLTree {
    private TreeNode root;

    public AVLTree() {
        this.root = null;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(int val) {
        this.root = this.addRecursive(this.root, val);
    }

    private TreeNode leftRotation(TreeNode node) {
        if (node == null || node.right == null) {
            return node;
        }
        TreeNode right = node.right;
        TreeNode rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
        return right;
    }

    private TreeNode rightRotation(TreeNode node) {
        if (node == null || node.left == null) {
            return node;
        }
        TreeNode left = node.left;
        TreeNode leftRight = left.right;
        left.right = node;
        node.left = leftRight;
        node.height = Math.max(getHeight(node.left), getHeight(node.right));
        left.height = Math.max(getHeight(left.left), getHeight(left.right));
        return left;
    }

    private TreeNode addRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val, 1);
        }
        if (node.val == val) {
            return node;
        }
        if (val < node.val) {
            node.left = this.addRecursive(node.left, val);
        }
        if (val > node.val) {
            node.right = this.addRecursive(node.right, val);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = this.getBalance(node);
        if (balance > 1 && val < node.left.val) {
            return rightRotation(node);
        }
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        return node;
    }

    public String toString() {
        return Trees.toString(this.root);
    }
}
