package Leetcode.LinkedList.MaximumTwinSum;

import Leetcode.LinkedList.LinkedListConstructor;
import Leetcode.LinkedList.ListNode;

public class Solution {
        public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        int result = 0;
        while(slow!=null){
            result = Math.max(result, prev.val+slow.val);
            prev = prev.next;
            slow = slow.next;
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode head = LinkedListConstructor.constructLinkedList(new int[]{4,2,2,3});
        LinkedListConstructor.printLinkedList(head);
        Solution s1 = new Solution();
        System.out.println(s1.pairSum(head));
      
    }
}
