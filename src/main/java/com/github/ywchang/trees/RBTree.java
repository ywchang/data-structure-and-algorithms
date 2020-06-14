package com.github.ywchang.trees;

public class RBTree {
    private TreeNode root = null;

    public void add(int val) {
        TreeNode node = new TreeNode(val, "red");
        this.root = insertRecursive(this.root, node);
        fixViolation(node, root);
    }

    private void fixViolation(TreeNode node, TreeNode root) {
        if (node == root) {
            node.color = "black";
            return;
        }
        if (node.parent == root) {
            return;
        }
        TreeNode parent = node.parent;
        if (parent.color.equals("black")) {
            return;
        }
        TreeNode grandParent = parent.parent;
        String firstPosition = (parent == grandParent.left) ? "left" : "right";
        String secondPosition = (node == parent.left) ? "left" : "right";
        TreeNode uncle = firstPosition.equals("left") ? grandParent.right : grandParent.left;
        if (uncle != null && uncle.color.equals("red")) {
            parent.color = "black";
            uncle.color = "black";
            grandParent.color = "red";
            fixViolation(grandParent, root);
            return;
        }
        if (firstPosition.equals("left") && secondPosition.equals("left")) {
            rightRotation(grandParent);
            grandParent.color = "red";
            parent.color = "black";
            return;
        }
        if (firstPosition.equals("right") && secondPosition.equals("right")) {
            leftRotation(grandParent);
            grandParent.color = "red";
            parent.color = "black";
            return;
        }
        if (firstPosition.equals("left") && secondPosition.equals("right")) {
            leftRotation(parent);
            rightRotation(grandParent);
            grandParent.color = "red";
            node.color = "black";
            return;
        }
        if (firstPosition.equals("right") && secondPosition.equals("left")) {
            rightRotation(parent);
            leftRotation(grandParent);
            grandParent.color = "red";
            node.color = "black";
            return;
        }
    }

    private void rightRotation(TreeNode node) {
        TreeNode parent = node.parent;
        TreeNode left = node.left;
        TreeNode leftRight = left.right;
        node.left = leftRight;
        left.right = node;
        if (leftRight != null) {
            leftRight.parent = node;
        }
        node.parent = left;
        left.parent = parent;
        if (parent == null) {
            this.root = left;
        } else if (parent.left == node) {
            parent.left = left;
        } else {
            parent.right = left;
        }
    }

    private void leftRotation(TreeNode node) {
        TreeNode parent = node.parent;
        TreeNode right = node.right;
        TreeNode rightLeft = right.left;
        node.right = rightLeft;
        right.left = node;
        if (rightLeft != null) {
            rightLeft.parent = node;
        }
        node.parent = right;
        right.parent = parent;
        if (parent == null) {
            this.root = right;
        } else if (parent.left == node) {
            parent.left = right;
        } else {
            parent.right = right;
        }
    }

    private TreeNode insertRecursive(TreeNode node, TreeNode newNode) {
        if (node == null) {
            return newNode;
        }
        if (newNode.val < node.val) {
            node.left = insertRecursive(node.left, newNode);
            node.left.parent = node;
        } else if (newNode.val > node.val) {
            node.right = insertRecursive(node.right, newNode);
            node.right.parent = node;
        }
        return node;
    }

    public String toString() {
        return Trees.toString(this.root);
    }
}
