package com.github.ywchang.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {
    @Test
    public void should_add_single_node() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        assertEquals("[0]", avl.toString());
    }

    @Test
    public void should_balance_left_left_when_adding_nodes() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(-1);
        avl.add(-2);
        assertEquals("[-1, -2, 0]", avl.toString());
    }

    @Test
    public void should_balance_left_right_when_adding_nodes() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(-2);
        avl.add(-1);
        assertEquals("[-1, -2, 0]", avl.toString());
    }

    @Test
    public void should_balance_right_right_when_adding_nodes() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(1);
        avl.add(2);
        assertEquals("[1, 0, 2]", avl.toString());
    }

    @Test
    public void should_balance_right_left_when_adding_nodes() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(2);
        avl.add(1);
        assertEquals("[1, 0, 2]", avl.toString());
    }

    @Test
    public void should_keep_balanced_when_adding_multiple_nodes() {
        AVLTree avlTree = new AVLTree();
        avlTree.add(1);
        assertEquals("[1]", avlTree.toString());
        avlTree.add(2);
        assertEquals("[1, null, 2]", avlTree.toString());
        avlTree.add(3);
        assertEquals("[2, 1, 3]", avlTree.toString());
        avlTree.add(4);
        assertEquals("[2, 1, 3, null, null, null, 4]", avlTree.toString());
        avlTree.add(5);
        assertEquals("[2, 1, 4, null, null, 3, 5]", avlTree.toString());
        avlTree.add(6);
        assertEquals("[4, 2, 5, 1, 3, null, 6]", avlTree.toString());
        avlTree.add(7);
        assertEquals("[4, 2, 6, 1, 3, 5, 7]", avlTree.toString());
        avlTree.add(8);
        assertEquals("[4, 2, 6, 1, 3, 5, 7, null, null, null, null, null, null, null, 8]", avlTree.toString());
    }

    @Test
    public void should_search_if_node_exists() {
        AVLTree avlTree = new AVLTree();
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(3);
        TreeNode treeNode = avlTree.search(3);
        assertEquals(3, treeNode.val);
    }

    @Test
    public void should_search_null_if_node_does_not_exist() {
        AVLTree avlTree = new AVLTree();
        avlTree.add(1);
        TreeNode treeNode = avlTree.search(2);
        assertNull(treeNode);
    }

    @Test
    public void should_remove_val_from_tree() {
        AVLTree avlTree = new AVLTree();
        avlTree.add(1);
        avlTree.add(2);
        avlTree.add(3);
        avlTree.add(4);
        avlTree.add(5);
        avlTree.add(6);
        avlTree.add(7);
        avlTree.add(8);
        avlTree.remove(4);
        assertEquals("[5, 2, 7, 1, 3, 6, 8]", avlTree.toString());

    }
}