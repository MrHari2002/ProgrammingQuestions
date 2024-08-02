package Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    // Convert an array to a binary tree
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < array.length) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Print the tree structure in a more visual format
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        int height = getHeight(root);
        int maxWidth = (int) Math.pow(2, height) - 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (level < height) {
            int levelNodes = (int) Math.pow(2, level);
            int spaces = (maxWidth - levelNodes) / (levelNodes + 1);
            int betweenSpaces = spaces * 2 + 1;

            // Initial spaces before the first node
            for (int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < levelNodes; i++) {
                if (queue.isEmpty()) {
                    break;
                }

                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }

                // Spaces between nodes
                for (int j = 0; j < betweenSpaces; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            level++;
        }
    }

    // Helper method to get the height of the tree
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
