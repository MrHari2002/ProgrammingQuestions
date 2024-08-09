package Leetcode.BinaryTree.DeleteNodeInBST;

import Leetcode.BinaryTree.TreeNode;
import Leetcode.BinaryTree.TreeUtil;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(key>root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key<root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            TreeNode current = root.right;
            while(current.left!=null){
                current = current.left;
            }
            root.val = current.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;

    }
    public static void main(String[] args) {
        Integer[] array = {5,3,6,2,4,null,7};
        int key = 3;
        Solution s1 = new Solution();
        TreeNode root = TreeUtil.arrayToTreeNode(array);
        TreeUtil.printTree(root);
        TreeNode result = s1.deleteNode(root, key);
        TreeUtil.printTree(result);
        
    }
}
