package com.github.ywchang.trees;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;
    public String color = "";
    public int height = -1;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, int height) {
        this.val = val;
        this.height = height;
    }

    public TreeNode(int val, String color) {
        this.val = val;
        this.color = color;
    }

    public String toString() {
        if (color.isEmpty()) {
            return String.valueOf(this.val);
        }
        return String.format("%d(%s)", this.val, this.color.substring(0, 1));
    }
}
