/*
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */

// SOLUTION

/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 * int val; 
 * ListNode next; 
 * ListNode() {} 
 * ListNode(int val) { this.val = val; } 
 * ListNode(int val,ListNode next) { 
 * this.val = val; this.next = next; 
 * } 
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0, head);
        head = temp;
        while (temp.next != null) {
            if (temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head.next;
    }
}