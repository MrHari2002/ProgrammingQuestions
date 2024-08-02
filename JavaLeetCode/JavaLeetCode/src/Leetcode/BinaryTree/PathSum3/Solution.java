package Leetcode.BinaryTree.PathSum3;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return pathSum(root.left, sum) + pathSum_a(root, (long)sum) + pathSum(root.right, sum);
    }
    public int pathSum_a(TreeNode root, long sum){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val == sum){
            res++;
        }
        res += pathSum_a(root.left, sum-root.val);
        res += pathSum_a(root.right, sum-root.val);
        return res;
    }






    public static void main(String[] args) {
        Integer[] array = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode root = TreeUtil.arrayToTreeNode(array);
        TreeUtil.printTree(root);
        Solution s1 = new Solution();
        System.out.println(s1.pathSum(root, 0));
    }
}
