package Leetcode.BinaryTree.CountGoodNodesInBinaryTree;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;


public class Solution {
    int goodNodes = 0;
    public Solution(){
        goodNodes = 0;
    }
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }
    public void dfs(TreeNode node, int maxSoFar){
        if(maxSoFar<=node.val){
            goodNodes++;
        }
        if(node.right!=null){
            dfs(node.right, Math.max(node.val, maxSoFar));
        }
        if(node.left!=null){
            dfs(node.left, Math.max(node.val, maxSoFar));
        }

    }
    public static void main(String[] args) {
        Integer[] array = {1};
        TreeNode root = TreeUtil.arrayToTreeNode(array);

        // Print the tree
        TreeUtil.printTree(root);
        Solution s1 = new Solution();
        System.out.println(
            s1.goodNodes(root)
        );
    }
}