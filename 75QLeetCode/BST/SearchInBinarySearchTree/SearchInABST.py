# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    ReturnNode = TreeNode()

    def searchBST(self, root: [TreeNode], val: int) -> [TreeNode]:
        Solution.ReturnNode = None
        Solution.BST(Solution,root,val)
        return Solution.ReturnNode

    def BST(self, root: [TreeNode], val: int):
        if not root:
            pass
        elif root.val == val:
            Solution.ReturnNode = root 
        else:
            Solution.BST(Solution,root.left,val)
            Solution.BST(Solution,root.right,val)

root = TreeNode(4)
root.left = TreeNode(2)
root.right = TreeNode(7)
root.left.left = TreeNode(1)
root.left.right = TreeNode(3)
print(Solution.searchBST(Solution,root,5))
