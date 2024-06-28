package Leetcode.LinkedList.OddEvenLinkedList;

import Leetcode.LinkedList.LinkedListConstructor;
import Leetcode.LinkedList.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        };
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        
        ListNode head = LinkedListConstructor.constructLinkedList(new int[]{2,1,3,5,6,4,7});
        LinkedListConstructor.printLinkedList(head);
        ListNode newHead = s1.oddEvenList(head);
        LinkedListConstructor.printLinkedList(newHead);
    }
}
