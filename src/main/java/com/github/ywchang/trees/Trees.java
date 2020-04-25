package com.github.ywchang.trees;

import java.util.*;

public class Trees {
    public static String toString(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return Arrays.toString(result.toArray());
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode n = queue.pollFirst();
            if (n == null) {
                result.add(null);
            } else {
                result.add(n.val);
                queue.offerLast(n.left);
                queue.offerLast(n.right);
            }
        }
        for (int i = result.size() - 1; i >= 0 && result.get(i) == null; i--) {
            result.remove(i);
        }
        return Arrays.toString(result.toArray());
    }
}

