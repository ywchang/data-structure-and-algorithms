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
    public void should_balance_left_left() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(-1);
        avl.add(-2);
        assertEquals("[-1, -2, 0]", avl.toString());
    }

    @Test
    public void should_balance_left_right() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(-2);
        avl.add(-1);
        assertEquals("[-1, -2, 0]", avl.toString());
    }

    @Test
    public void should_balance_right_right() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(1);
        avl.add(2);
        assertEquals("[1, 0, 2]", avl.toString());
    }

    @Test
    public void should_balance_right_left() {
        AVLTree avl = new AVLTree();
        avl.add(0);
        avl.add(2);
        avl.add(1);
        assertEquals("[1, 0, 2]", avl.toString());
    }
}