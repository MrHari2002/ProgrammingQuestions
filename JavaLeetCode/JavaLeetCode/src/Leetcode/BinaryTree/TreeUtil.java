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
        int h = getHeight(root);
        int col = getColumn(h);
        int[][] M = new int[h][col];
        printTree(M, root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static void printTree(int[][] M, TreeNode root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.val;
        printTree(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
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

    // Helper method to get the Column of the tree
    private static int getColumn(int h) {
        if (h == 1)
            return 1;
        return getColumn(h - 1) + getColumn(h - 1) + 1;
    }

}
