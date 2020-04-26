package com.github.ywchang.trees;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public int height = -1;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, int height) {
        this.val = val;
        this.height = height;
    }
}
