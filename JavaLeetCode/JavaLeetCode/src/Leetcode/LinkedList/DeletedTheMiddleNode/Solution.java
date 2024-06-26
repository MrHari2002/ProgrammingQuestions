package Leetcode.LinkedList.DeletedTheMiddleNode;

import Leetcode.LinkedList.ListNode;

public class Solution {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next.equals(null)){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;    
    }


    public static void main(String[] args) {
        Solution s1 = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next =new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(8);

        ListNode cur = head;
        while(cur.next!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        
        System.out.println("post");
        cur = s1.deleteMiddle(head);
        
        while(cur.next!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }    
    }
}
