package com.github.ywchang.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTest {
    @Test
    public void should_add_values_to_red_black_tree_with_descending_order() {
        RBTree tree = new RBTree();
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        assertEquals("[6(b), 4(r), 7(b), 2(b), 5(b), null, null, 1(r), 3(r)]", tree.toString());
    }

    @Test
    public void should_add_values_to_red_black_tree_with_ascending_numbers() {
        RBTree tree = new RBTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertEquals("[2(b), 1(b), 4(r), null, null, 3(b), 6(b), null, null, 5(r), 7(r)]", tree.toString());
    }

    @Test
    public void should_add_values_to_red_black_tree_with_random_numbers() {
        RBTree tree = new RBTree();
        tree.add(9);
        assertEquals("[9(b)]", tree.toString());
        tree.add(6);
        assertEquals("[9(b), 6(r)]", tree.toString());
        tree.add(8);
        assertEquals("[8(b), 6(r), 9(r)]", tree.toString());
        tree.add(3);
        assertEquals("[8(b), 6(b), 9(b), 3(r)]", tree.toString());
        tree.add(5);
        assertEquals("[8(b), 5(b), 9(b), 3(r), 6(r)]", tree.toString());
        tree.add(1);
        assertEquals("[8(b), 5(r), 9(b), 3(b), 6(b), null, null, 1(r)]", tree.toString());
        tree.add(7);
        assertEquals("[8(b), 5(r), 9(b), 3(b), 6(b), null, null, 1(r), null, null, 7(r)]", tree.toString());
        tree.add(4);
        assertEquals("[8(b), 5(r), 9(b), 3(b), 6(b), null, null, 1(r), 4(r), null, 7(r)]", tree.toString());
        tree.add(2);
        assertEquals("[5(b), 3(r), 8(r), 1(b), 4(b), 6(b), 9(b), null, 2(r), null, null, null, 7(r)]", tree.toString());
    }
}