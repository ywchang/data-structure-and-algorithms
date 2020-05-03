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
        if (balance < -1 && val > node.right.val) {
            return leftRotation(node);
        }
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotation(node.right);
            return this.leftRotation(node);
        }
        return node;
    }

    public TreeNode search(int val) {
        return this.searchRecursive(this.root, val);
    }

    private TreeNode searchRecursive(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        }
        if (val < node.val) {
            return this.searchRecursive(node.left, val);
        }
        return this.searchRecursive(node.right, val);
    }

    public String toString() {
        return Trees.toString(this.root);
    }

    public void remove(int val) {
        this.root = this.removeRecursive(this.root, val);
    }

    private int getMinVal(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    private TreeNode removeRecursive(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.val) {
            node.left = this.removeRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = this.removeRecursive(node.right, val);
        } else if (node.left == null) {
            node = node.right;
        } else if (node.right == null) {
            node = node.left;
        } else {
            int minVal = getMinVal(node.right);
            node.val = minVal;
            node.right = this.removeRecursive(node.right, minVal);
        }
        if (node == null) {
            return null;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balance = getBalance(node);
        if (balance < -1 && getBalance(node.right) < 0) {
            return this.leftRotation(node);
        }
        if (balance < -1 && getBalance(node.right) >= 0) {
            node.right = rightRotation(node.right);
            return this.leftRotation(node);
        }
        if (balance > 1 && getBalance(node.left) >= 0) {
            return this.rightRotation(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotation(node.left);
            return this.rightRotation(node);
        }
        return node;
    }
}
