package Leetcode.BinaryTree.BinaryTreeRightSideView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;


public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        if(root!=null){
            nodes.add(root);
        }
        else{
            return new ArrayList<Integer>();
        }

        while(nodes.size()!=0){
            TreeNode rightSide = null;
            Integer nodesLength = nodes.size();

            for(int i = 0; i<nodesLength;i++){
                TreeNode node = nodes.pop();
                if(node!=null){
                    rightSide = node;
                    if(node.left!=null){
                    nodes.add(node.left);
                    }
                    if(node.right!=null){
                    nodes.add(node.right);
                    }
                }
            }

            if(rightSide!=null){
                results.add(rightSide.val);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,2,3,null,5,null,4};
        TreeNode treeNode = TreeUtil.arrayToTreeNode(root);
        TreeUtil.printTree(treeNode);
        Solution s1 = new Solution();
        List<Integer> results = s1.rightSideView(treeNode);
        for(Integer i :results){
            System.out.println(i);
        }
    }
}