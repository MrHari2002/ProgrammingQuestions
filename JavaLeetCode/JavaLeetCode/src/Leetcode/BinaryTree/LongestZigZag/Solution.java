package Leetcode.BinaryTree.LongestZigZag;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;

public class Solution {
    public int longestZigZag(TreeNode root) {
        return Math.max(zigZag(root.left, true, 0), zigZag(root.right, false, 0));
    }

    private int zigZag(TreeNode node,Boolean isLeft,int depth){
        if(node==null){
            return depth;
        }
        if(isLeft){
            depth = Math.max(depth, Math.max(zigZag(node.right, false, depth+1),zigZag(node.left, true, 0)));
        }
        else{
            depth = Math.max(depth, Math.max(zigZag(node.left, true, depth+1),zigZag(node.right, false, 0)));
        }
        return depth;
    } 


    public static void main(String[] args) {
        Integer[] zigZag = {1,1,1,null,1,null,null,1,1,null,1};
        TreeNode root = TreeUtil.arrayToTreeNode(zigZag);
        TreeUtil.printTree(root);
        Solution s1 = new Solution();
        System.out.println(s1.longestZigZag(root));
    }
}
