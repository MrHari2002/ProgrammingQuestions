package Leetcode.BinaryTree.MaxiumLevelSum;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;

import java.util.ArrayDeque;
import java.util.Deque;


public class Solution {
    public int maxLevelSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int level = 0;
        int max = Integer.MIN_VALUE;
        int results = 0;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(root);
        while(nodes.size()!=0){
            int counts = nodes.size();
            int sum = 0;
            level++;
            while(counts!=0){
                TreeNode temp = nodes.pop();
                if(temp!=null){
                    sum+=temp.val;
                }
                if(temp.left!=null){
                    nodes.add(temp.left);
                }
                if(temp.right!=null){
                    nodes.add(temp.right);
                }
                counts--;
            }
            if(sum>max){
                results = level;
                max = sum;
            }
        }
        return results;
    }
    public static void main(String[] args) {
        Integer[] array = {-100,-200,-300,-20,-5,-10,null};
        TreeNode root = TreeUtil.arrayToTreeNode(array);
        TreeUtil.printTree(root);
        Solution s1 = new Solution();
        System.out.println(s1.maxLevelSum(root));
    }
}
