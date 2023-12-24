# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def leafSimilar(self, root1: [TreeNode], root2: [TreeNode]) -> bool:
        leafArray1 = []
        leafArray2 = []
        Solution.leafValue(Solution,leafArray1,root1)
        Solution.leafValue(Solution,leafArray2,root2)
        return leafArray1 == leafArray2

    def leafValue(self, leafArray, root:[TreeNode]):
        if root: 
            if not(root.left or root.right):
                leafArray.append(root.val)
            Solution.leafValue(Solution ,leafArray, root.left)
            Solution.leafValue(Solution ,leafArray, root.right)

    
# root1 = TreeNode(3)
# root1.left = TreeNode(5)
# root1.right = TreeNode(1)
# root1.left.left = TreeNode(6)
# root1.left.right = TreeNode(2)
# root1.right.left = TreeNode(9)
# root1.right.right = TreeNode(8)
# root1.left.right.left = TreeNode(7)
# root1.left.right.right = TreeNode(4)

root1 = TreeNode(1)
root1.left = TreeNode(2)
root2 = TreeNode(2)
root2.left = TreeNode(2)

print(Solution.leafSimilar(Solution,root1,root2))