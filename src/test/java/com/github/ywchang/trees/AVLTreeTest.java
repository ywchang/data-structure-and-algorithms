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
}