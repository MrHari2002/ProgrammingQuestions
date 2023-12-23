# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def maxDepth(self, root: [TreeNode]) -> int:
        if not root:
            return 0
        else:
            left_depth = self.maxDepth(Solution,root.left)
            right_depth = self.maxDepth(Solution,root.right)
            return max(left_depth, right_depth) + 1

    
# root = TreeNode(3)
# root.left = TreeNode(9)
# root.right = TreeNode(20)
# root.right.left = TreeNode(15)
# root.right.right = TreeNode(7)
root = TreeNode(1)
root.right = TreeNode(2)
print(Solution.maxDepth(Solution,root))