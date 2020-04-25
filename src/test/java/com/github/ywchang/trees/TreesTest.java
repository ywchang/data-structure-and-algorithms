package com.github.ywchang.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreesTest {
    @Test
    public void should_to_string_for_null() {
        assertEquals("[]", Trees.toString(null));
    }

    @Test
    public void should_to_string_for_single_tree_node() {
        TreeNode root = new TreeNode(0);
        String treeString = Trees.toString(root);
        assertEquals("[0]", treeString);
    }

    @Test
    public void should_to_string_for_singe_tree_branch() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;
        String treeString = Trees.toString(root);
        assertEquals("[0, 1]", treeString);
    }

    @Test
    public void should_to_string_for_complex_tree() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(4);
        root.left = left;
        left.left = leftLeft;
        root.right = right;
        right.right = rightRight;
        String treeString = Trees.toString(root);
        assertEquals("[0, 1, 2, 3, null, null, 4]", treeString);
    }
}