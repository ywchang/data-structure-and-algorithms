package com.github.ywchang.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void should_add_single_root_node() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        assertEquals("[0]", bst.toString());
    }

    @Test
    public void should_add_notes_in_sequence() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        assertEquals("[0, null, 1, null, 2]", bst.toString());
    }

    @Test
    public void should_search_if_node_exists() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        TreeNode node = bst.search(2);
        assertEquals(2, node.val);
    }

    @Test
    public void should_search_if_node_does_not_exist() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        TreeNode node = bst.search(3);
        assertEquals(null, node);
    }

    @Test
    public void should_delete_node_which_does_not_exist() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        bst.remove(3);
        assertEquals("[0, null, 1, null, 2]", bst.toString());
    }

    @Test
    public void should_delete_leaf_node() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        bst.remove(2);
        assertEquals("[0, null, 1]", bst.toString());
    }

    @Test
    public void should_delete_node_with_single_branch() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(0);
        bst.add(1);
        bst.add(2);
        bst.remove(0);
        assertEquals("[1, null, 2]", bst.toString());
    }

    @Test
    public void should_delete_node_with_two_branches() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);
        bst.add(0);
        bst.add(3);
        bst.add(2);
        bst.remove(1);
        assertEquals("[2, 0, 3]", bst.toString());
    }

}