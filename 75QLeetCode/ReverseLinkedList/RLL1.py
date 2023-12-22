
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: [ListNode]) -> [ListNode]:
        current = head
        prev = None

        while current:
            nex = current.next
            current.next = prev
            prev = current
            current = nex
        
        return prev
    
Head = ListNode(1)
Head.next = ListNode(2)
Head.next.next = ListNode(3)

print(Solution.reverseList(Solution,Head))