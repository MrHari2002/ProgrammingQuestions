# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: [ListNode]) -> [ListNode]:
        if not head:
            return None
        nextHead = head

        if head.next:
            nextHead = Solution.reverseList(self,head.next)
            head.next.next = head
        head.next = None
        return nextHead
    
Head = ListNode(1)
Head.next = ListNode(2)
Head.next.next = ListNode(3)

print(Solution.reverseList(Solution,Head))