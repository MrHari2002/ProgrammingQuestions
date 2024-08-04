package Leetcode.BinaryTree.LowestCommonAncestorOfaBinaryTree;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);

        if(leftTreeNode!=null && rightTreeNode!=null){
            return root;
        }
        else if(leftTreeNode!=null){
            return leftTreeNode;
        }
        else if(rightTreeNode!=null){
            return rightTreeNode;
        }

        return null;
    }
    public static void main(String[] args) {
        Integer[] newIntegers = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeUtil.arrayToTreeNode(newIntegers);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        Solution s1 = new Solution();
        System.out.println(s1.lowestCommonAncestor(root, p, q).val);
    }
    
}
