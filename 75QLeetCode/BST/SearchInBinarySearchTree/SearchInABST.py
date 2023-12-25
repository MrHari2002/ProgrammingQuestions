# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def searchBST(self, root: [TreeNode], val: int) -> [TreeNode]:
        if not root:
            return None
        if root.val == val:
            return root
        Solution.searchBST(Solution,root.left)
        Solution.searchBST(Solution,root.right)

root = TreeNode(4)
root.left = TreeNode(2)
root.right = TreeNode(7)
root.left.left = TreeNode(1)
root.left.right = TreeNode(3)
